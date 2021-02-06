package com.anupkamthe.socceracademy.team.controller




import com.anupkamthe.socceracademy.team.data.PlayersEntity
import com.anupkamthe.socceracademy.team.service.PlayersService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import org.springframework.web.bind.annotation.RequestBody

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment


@RestController
@RequestMapping("/api/players")
class PlayersController(private val playersService: PlayersService) {

    @Autowired
    private val env: Environment? = null
    //Welcome
    @GetMapping("/welcome")
    fun welcome() : String = "Welcome to the Soccer Academy"

    //Status
    @GetMapping("/status/check")
    fun status(): String = "Player Controller Working on port: " + env!!.getProperty("local.server.port")

    //Get list of all the players
    @GetMapping
    fun getAllPlayers() : List<PlayersEntity> = playersService.getAll()

    //Create a player
    @PostMapping("/createplayer" ,consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createPlayer(@Valid @RequestBody player : PlayersEntity): ResponseEntity<PlayersEntity> = ResponseEntity.ok(playersService.createPlayer(player))

    //Get Player by Id
    @GetMapping("/getById")
    fun getPlayerById(@RequestParam(value = "id") id: Long): ResponseEntity<PlayersEntity> =
        playersService.getPlayerById(id).map { task ->
            ResponseEntity.ok(task)
        }.orElse(ResponseEntity.notFound().build())

    //Update Player Info by Id
    @PutMapping("/{playerId}")
    fun updatePlayerById(
        @PathVariable(value = "playerId") playerId: Long,
        @Valid @RequestBody newTask: PlayersEntity): ResponseEntity<PlayersEntity> =
        playersService.updatePlayer(playerId, newTask)
            .map { task -> ResponseEntity.ok().body(task) }
            .orElse(ResponseEntity.notFound().build())

    //Delete Player By Id
    @DeleteMapping("/{playerId}")
    fun deleteTask(@PathVariable(value = "playerId") playerId: Long): ResponseEntity<Void> =
        if (playersService.deleteByPlayerId(playerId))
            ResponseEntity<Void>(HttpStatus.ACCEPTED)
        else
            ResponseEntity.notFound().build()

    //CUSTOM QUERY: get player list by position
    @GetMapping("/queryByPosition/{position}")
    fun getPlayersByPosition(@PathVariable position: String) : List<PlayersEntity> = playersService.findAllByPosition(position)

    //CUSTOM QUERY: get player list by age
    @GetMapping("/age/{age}")
    fun getPlayersByAge(@PathVariable age: Int) : List<PlayersEntity> = playersService.findByAge(age)

    //CUSTOM QUERY: get player list by age
    @GetMapping("/queryBySquadNumber/{squadNumber}")
    fun getSquadNumberAvailability(@PathVariable squadNumber: Int) : String = playersService.isSquadNumberAvailable(squadNumber)
}
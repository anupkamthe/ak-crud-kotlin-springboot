package com.anupkamthe.socceracademy.team.service


import com.anupkamthe.socceracademy.team.data.PlayersEntity
import com.anupkamthe.socceracademy.team.data.PlayersRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PlayersService(val playersRepo : PlayersRepository) {
    fun getAll(): List<PlayersEntity> =  playersRepo.findAll()
    fun createPlayer(player: PlayersEntity): PlayersEntity = playersRepo.save(player)
    fun getPlayerById(playerid: Long): Optional<PlayersEntity> = playersRepo.findById(playerid)
    fun updatePlayer(playerid: Long, updatedPlayer: PlayersEntity): Optional<PlayersEntity> =
        playersRepo.findById(playerid).map { currentPlayer ->
            val newPlayer: PlayersEntity =
                currentPlayer.copy(firstName = updatedPlayer.firstName, lastName =  updatedPlayer.lastName, position = updatedPlayer.position, age = updatedPlayer.age, squadNumber = updatedPlayer.squadNumber, emailAddress = updatedPlayer.emailAddress)
            playersRepo.save(newPlayer)
        }
    fun deleteByPlayerId(playerId: Long): Boolean = playersRepo.findById(playerId).map {
            player -> playersRepo.delete(player)
        true
    }.orElse(false)
    fun isSquadNumberAvailable(squadNumber: Int) = playersRepo.findBySquadNumber(squadNumber)
    fun findAllByPosition(position: String): List<PlayersEntity> = playersRepo.findAllByPosition(position)
    fun findByAge(age: Int): List<PlayersEntity> = playersRepo.findByAge(age)
    //  fun countByPosition(position: String) = playersDAO.countByPosition(position)

}
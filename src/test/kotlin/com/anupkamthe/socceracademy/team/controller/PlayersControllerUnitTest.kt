package com.anupkamthe.socceracademy.team.controller
import com.anupkamthe.socceracademy.team.service.PlayersService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner



@RunWith(MockitoJUnitRunner::class)
class PlayersControllerUnitTest() {
    @InjectMocks
    lateinit var playersController: PlayersController
    @Mock
    lateinit var playersService: PlayersService



    @Test
    fun testPlayersController() {
        val result = playersController.welcome()
        assertNotNull(result)
        assertEquals("Welcome to the Soccer Academy", result)
    }

/*


    @Test
    fun `List users`() {
        val player1 = PlayersEntity(1, "anup", "kamthe", "Striker", 25, 10, "anup@test.com")
        val player2 = PlayersEntity(2, "test", "test", "Defender", 30, 7, "anup@test.com")
        every { playersService.getAll() } returns listOf(player1, player2)
        mockMvc.perform(d("/api/players/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].firstName").value(player1.firstName))
            .andExpect(jsonPath("\$.[1].firstName").value(player2.firstName))
    }




    @Test
    fun `with correct payload having one mobile id in a list and message - request returns http ok and response`() {
        val player1 = PlayersEntity(1, "anup", "kamthe", "Striker", 25, 10, "anup@test.com")
   //     mockMvc.perform(post(urlPath).contentType(MediaType.APPLICATION_JSON))
    //        .andExpect(status().isAccepted)
    }


    @Test
    fun `controller Must return User`() {
        // save an user
        val player = PlayersEntity(1, "anup", "kamthe", "Striker", 50, 10, "anup@test.com")
        val play = playersService.playersRepo.save(player)
        val result : ResponseEntity<PlayersEntity> = playersController.getPlayerById(1)
        Assertions.assertTrue(result.statusCode == HttpStatus.ACCEPTED)

       // mockMvc.perform(MockMvcRequestBuilders.get("/players/"))
         //   .andExpect(MockMvcResultMatchers.status().isOk)
        //.andExpect(MockMvcResultMatchers.jsonPath("\$.firstName").value(user.firstName))
        //.andExpect(MockMvcResultMatchers.jsonPath("\$.lastName").value(user.lastName))

    }
    companion object {
        const val urlPath = "/api/players/createplayer"
    }

    @Test
    fun testSquadNumber() {
        val squadNumber = 10
        val result = playersController.getSquadNumberAvailability(squadNumber)
        assertNotNull(result)
        assertEquals(squadNumber, result)
    }

 */
}
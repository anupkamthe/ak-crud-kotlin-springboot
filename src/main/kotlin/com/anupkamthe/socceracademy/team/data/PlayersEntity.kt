package com.anupkamthe.socceracademy.team.data

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank


@Entity(name = "Players")
@NamedQuery(name = "Players.findByPosition", query = "SELECT p FROM Players p WHERE LOWER(p.position) = LOWER(?1)")
data class PlayersEntity(
    @Id @GeneratedValue(
        strategy = GenerationType.IDENTITY) val id : Long = 0,
    @get: NotBlank val firstName : String = "",
    @get: NotBlank val lastName: String = "",
    @get: NotBlank val position : String = "",
    val age : Int,
    val squadNumber : Int,
    @Email val emailAddress : String){
}
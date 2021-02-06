package com.anupkamthe.socceracademy.team.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PlayersRepository : JpaRepository<PlayersEntity, Long>{
    @Query("FROM Players WHERE position = :position ORDER BY firstName DESC")
    fun findAllByPosition(@Param("position") position: String):
            List<PlayersEntity>

    fun findByAge(age: Int): List<PlayersEntity>

    @Query("Select Distinct squadNumber FROM Players WHERE squadNumber = :squadNumber")
    fun findBySquadNumber(squadNumber: Int): String

}

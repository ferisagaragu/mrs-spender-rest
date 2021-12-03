package org.pechblenda.mrsspender.repository

import org.pechblenda.mrsspender.entity.Room

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

import java.util.UUID

interface IRoomRepository: JpaRepository<Room, UUID> {

	@Query("select room from Room room order by room.createDate")
	override fun findAll(): MutableList<Room>

}

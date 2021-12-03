package org.pechblenda.mrsspender.repository

import org.pechblenda.mrsspender.entity.Place

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

import java.util.UUID

interface IPlaceRepository: JpaRepository<Place, UUID> {

	@Query(
		"select place from Place place " +
		"where place.room.uuid = :roomUuid " +
		"order by place.createDate asc"
	)
	fun findAllPlacesByRoomUuid(roomUuid: UUID): MutableList<Place>

}

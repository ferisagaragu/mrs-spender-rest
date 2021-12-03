package org.pechblenda.mrsspender.service.`interface`

import org.springframework.http.ResponseEntity

import org.pechblenda.service.Request

import java.util.UUID

interface IPlaceService {
	fun findAllPlacesByRoomUuid(roomUuid: UUID?): ResponseEntity<Any>
	fun createPlace(request: Request): ResponseEntity<Any>
	fun updatePlace(request: Request): ResponseEntity<Any>
	fun setPlace(placeUuid: UUID, status: Boolean): ResponseEntity<Any>
	fun deletePlace(placeUuid: UUID): ResponseEntity<Any>
}

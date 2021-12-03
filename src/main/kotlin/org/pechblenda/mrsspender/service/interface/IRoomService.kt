package org.pechblenda.mrsspender.service.`interface`

import org.springframework.http.ResponseEntity

import org.pechblenda.service.Request

import java.util.UUID

interface IRoomService {
	fun findAllRoomsByUuid(roomUuid: UUID?): ResponseEntity<Any>
	fun createRoom(request: Request): ResponseEntity<Any>
	fun updateRoom(request: Request): ResponseEntity<Any>
	fun deleteRoom(roomUuid: UUID): ResponseEntity<Any>
}

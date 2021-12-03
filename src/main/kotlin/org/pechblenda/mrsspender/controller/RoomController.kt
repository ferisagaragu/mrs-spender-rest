package org.pechblenda.mrsspender.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody

import org.pechblenda.exception.HttpExceptionResponse
import org.pechblenda.service.Request
import org.pechblenda.mrsspender.service.`interface`.IRoomService

import java.util.UUID

@CrossOrigin(methods = [
	RequestMethod.GET,
	RequestMethod.POST,
	RequestMethod.PUT,
	RequestMethod.DELETE
])
@RestController
@RequestMapping(name = "Room", value = ["/rest/rooms"])
class RoomController(
	private val roomService: IRoomService,
	private val httpExceptionResponse: HttpExceptionResponse
) {

	@GetMapping(value = ["", "/{roomUuid}"])
	fun findAllRoomsByUuid(
		@PathVariable roomUuid: UUID?
	): ResponseEntity<Any> {
		return try {
			roomService.findAllRoomsByUuid(roomUuid)
		} catch (e: ResponseStatusException) {
			httpExceptionResponse.error(e)
		}
	}

	@PostMapping
	fun createRoom(@RequestBody request: Request): ResponseEntity<Any> {
		return try {
			roomService.createRoom(request)
		} catch (e: ResponseStatusException) {
			httpExceptionResponse.error(e)
		}
	}

	@PutMapping
	fun updateRoom(@RequestBody request: Request): ResponseEntity<Any> {
		return try {
			roomService.updateRoom(request)
		} catch (e: ResponseStatusException) {
			httpExceptionResponse.error(e)
		}
	}

	@DeleteMapping("/{roomUuid}")
	fun deleteRoom(
		@PathVariable roomUuid: UUID
	): ResponseEntity<Any> {
		return try {
			roomService.deleteRoom(roomUuid)
		} catch (e: ResponseStatusException) {
			httpExceptionResponse.error(e)
		}
	}

}

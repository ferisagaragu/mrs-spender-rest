package org.pechblenda.mrsspender.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.DeleteMapping

import org.pechblenda.exception.HttpExceptionResponse
import org.pechblenda.service.Request
import org.pechblenda.mrsspender.service.`interface`.IPlaceService

import java.util.UUID

@CrossOrigin(methods = [
	RequestMethod.GET,
	RequestMethod.POST,
	RequestMethod.PUT,
	RequestMethod.PATCH,
	RequestMethod.DELETE
])
@RestController
@RequestMapping(name = "Place", value = ["/rest/places"])
class PlaceController(
	private val placeService: IPlaceService,
	private val httpExceptionResponse: HttpExceptionResponse
) {

	@GetMapping(value = ["", "/{roomUuid}"])
	fun findAllPlacesByRoomUuid(
		@PathVariable roomUuid: UUID?
	): ResponseEntity<Any> {
		return try {
			placeService.findAllPlacesByRoomUuid(roomUuid)
		} catch (e: ResponseStatusException) {
			httpExceptionResponse.error(e)
		}
	}

	@PostMapping
	fun createPlace(@RequestBody request: Request): ResponseEntity<Any> {
		return try {
			placeService.createPlace(request)
		} catch (e: ResponseStatusException) {
			httpExceptionResponse.error(e)
		}
	}

	@PutMapping
	fun updatePlace(@RequestBody request: Request): ResponseEntity<Any> {
		return try {
			placeService.updatePlace(request)
		} catch (e: ResponseStatusException) {
			httpExceptionResponse.error(e)
		}
	}

	@PatchMapping("/{placeUuid}/{status}")
	fun setPlace(
		@PathVariable placeUuid: UUID,
		@PathVariable status: Boolean
	): ResponseEntity<Any> {
		return try {
			placeService.setPlace(placeUuid, status)
		} catch (e: ResponseStatusException) {
			httpExceptionResponse.error(e)
		}
	}

	@DeleteMapping("/{placeUuid}")
	fun deletePlace(
		@PathVariable placeUuid: UUID
	): ResponseEntity<Any> {
		return try {
			placeService.deletePlace(placeUuid)
		} catch (e: ResponseStatusException) {
			httpExceptionResponse.error(e)
		}
	}

}

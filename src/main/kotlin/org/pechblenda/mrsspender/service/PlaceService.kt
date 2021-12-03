package org.pechblenda.mrsspender.service

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import org.pechblenda.service.Request
import org.pechblenda.service.Response
import org.pechblenda.mrsspender.repository.IPlaceRepository
import org.pechblenda.mrsspender.service.`interface`.IPlaceService

import java.util.UUID
import org.pechblenda.exception.NotFoundException
import org.pechblenda.mrsspender.entity.Place

@Service
class PlaceService(
	val placeRepository: IPlaceRepository,
	val response: Response
): IPlaceService {

	@Transactional(readOnly = true)
	override fun findAllPlacesByRoomUuid(roomUuid: UUID?): ResponseEntity<Any> {
		var places: MutableList<Place>

		if (roomUuid != null) {
			places = placeRepository.findAllPlacesByRoomUuid(roomUuid)

			places.forEach { place -> println(place.name) }

			return response.toListMap(places).ok()
		}

		places = placeRepository.findAll()

		return response.toListMap(places).ok()
	}

	@Transactional
	override fun createPlace(request: Request): ResponseEntity<Any> {
		TODO("Not yet implemented")
	}

	@Transactional
	override fun updatePlace(request: Request): ResponseEntity<Any> {
		TODO("Not yet implemented")
	}

	@Transactional
	override fun setPlace(placeUuid: UUID, status: Boolean): ResponseEntity<Any> {
		val place = placeRepository.findById(placeUuid).orElseThrow {
			NotFoundException("No se encuentra el espacio")
		}

		place.status = status

		return response.ok()
	}

	@Transactional
	override fun deletePlace(placeUuid: UUID): ResponseEntity<Any> {
		TODO("Not yet implemented")
	}

}

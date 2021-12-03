package org.pechblenda.mrsspender.service

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import org.pechblenda.service.Request
import org.pechblenda.service.Response
import org.pechblenda.style.Color
import org.pechblenda.mrsspender.repository.IRoomRepository
import org.pechblenda.mrsspender.service.`interface`.IRoomService
import org.pechblenda.mrsspender.entity.Room
import org.pechblenda.style.enums.CategoryColor
import org.pechblenda.exception.NotFoundException

import java.util.UUID
import org.pechblenda.service.enum.IdType
import org.pechblenda.service.helper.EntityParse

@Service
class RoomService(
	val roomRepository: IRoomRepository,
	val color: Color,
	val response: Response
): IRoomService {

	@Transactional(readOnly = true)
	override fun findAllRoomsByUuid(roomUuid: UUID?): ResponseEntity<Any> {
		return if (roomUuid == null) {
			response.toListMap(roomRepository.findAll()).ok()
		} else {
			response.toMap(roomRepository.findById(roomUuid!!)).ok()
		}
	}

	@Transactional
	override fun createRoom(request: Request): ResponseEntity<Any> {
		val room = request.to<Room>(Room::class)
		room.color = color.getMaterialColor(CategoryColor.MATERIAL_500).background
		roomRepository.save(room)

		return response.toMap(room).created()
	}

	@Transactional
	override fun updateRoom(request: Request): ResponseEntity<Any> {
		val room = request.merge<Room>(
			EntityParse(
				"uuid",
				roomRepository,
				IdType.UUID
			)
		)

		return response.ok()
	}

	@Transactional
	override fun deleteRoom(roomUuid: UUID): ResponseEntity<Any> {
		val room = roomRepository.findById(roomUuid).orElseThrow {
			NotFoundException("No se encuentra la habitación")
		}

		roomRepository.delete(room)

		return response.ok()
	}

}

package org.pechblenda.mrsspender.entity

import java.util.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.ManyToOne
import javax.persistence.PrePersist

import java.util.UUID

@Entity
@Table(name = "places")
class Place(
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	var uuid: UUID,
	var name: String,
	var note: String,
	var photoUrl: String,
	var status: Boolean,
	var createDate: Date,

	@ManyToOne
	var room: Room
) {

	@PrePersist
	fun onCreate() {
		if (createDate == null) {
			createDate = Date()
		}
	}

}

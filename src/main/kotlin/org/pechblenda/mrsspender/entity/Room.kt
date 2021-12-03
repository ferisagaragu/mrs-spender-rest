package org.pechblenda.mrsspender.entity

import java.util.Date
import java.util.UUID

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.PrePersist
import javax.persistence.Table

@Entity
@Table(name = "rooms")
class Room(
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	var uuid: UUID,
	var name: String,
	var icon: String,
	var color: String,
	var createDate: Date,

	@OneToMany(mappedBy = "room")
	var places: MutableList<Place>
) {

	@PrePersist
	fun onCreate() {
		if (createDate == null) {
			createDate = Date()
		}
	}

}
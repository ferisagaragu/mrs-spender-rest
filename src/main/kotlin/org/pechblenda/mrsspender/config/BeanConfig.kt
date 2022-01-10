package org.pechblenda.mrsspender.config

import org.pechblenda.auth.AuthController
import org.pechblenda.doc.Documentation
import org.pechblenda.mrsspender.controller.ItemController
import org.pechblenda.mrsspender.controller.RoomController

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan("org.pechblenda.bean")
class BeanConfig {

	@Bean
	fun documentation(): Documentation {
		return Documentation(
			AuthController::class,
			RoomController::class,
			ItemController::class
		)
	}

}
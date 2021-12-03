package org.pechblenda.mrsspender.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class BasePathConfig: WebMvcConfigurer {

	override fun addViewControllers(registry: ViewControllerRegistry) {
		registry.addViewController("/app").setViewName("forward:/index.html")
	}

}
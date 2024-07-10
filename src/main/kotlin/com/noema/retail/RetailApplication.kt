package com.noema.retail

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableConfigurationProperties(RetailProperties::class)
class RetailApplication

fun main(args: Array<String>) {

    runApplication<RetailApplication>(*args)
}

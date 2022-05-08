package com.aoj.softwareengnieer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping
@SpringBootApplication
class SoftwareEngnieerApplication

fun main(args: Array<String>) {
    runApplication<SoftwareEngnieerApplication>(*args)
}

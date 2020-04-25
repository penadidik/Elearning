package org.lintaspena.elearning

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ElearningApplication

fun main(args: Array<String>) {
	SpringApplication.run(ElearningApplication::class.java, *args)
}
package com.davidgracia.software.authorizationmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AuthorizationManager

fun main(args: Array<String>) {
    runApplication<AuthorizationManager>(*args)
}

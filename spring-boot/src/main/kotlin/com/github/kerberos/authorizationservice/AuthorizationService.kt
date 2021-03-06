package com.github.kerberos.authorizationservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AuthorizationService

fun main(args: Array<String>) {
    runApplication<AuthorizationService>(*args)
}

package com.github.kerberos.authorizationservice.librarysource.cqrs

import javax.inject.Named

@Named
class TemporaryCommandBus : CommandBus {
    override fun <C : Command> execute(command: C) {
        TODO("Not yet implemented")
    }
}

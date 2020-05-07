package com.github.kerberos.authorizationservice.librarysource.cqrs

import com.github.kerberos.authorizationservice.interaction.role.CreateRoleCommandHandler
import com.github.kerberos.authorizationservice.interaction.role.create.CreateRoleCommand

class SimpleCommandBus(
        private val createRoleCommandHandler: CreateRoleCommandHandler
) : CommandBus {
    override fun <C : Command> dispatch(command: C) {
        when(command) {
          is  CreateRoleCommand -> createRoleCommandHandler.handle(command)
        }
    }
}
package com.github.kerberos.authorizationservice.interaction.cqrs

import com.github.kerberos.authorizationservice.interaction.role.CreateRole
import com.github.kerberos.authorizationservice.interaction.role.create.CreateRoleCommand
import javax.inject.Named

@Named
class SimpleCommandBus(
    private val createRole: CreateRole
) : CommandBus {
    override fun <C : Command> dispatch(command: C) {
        when (command) {
            is CreateRoleCommand -> createRole.handle(command)
        }
    }
}

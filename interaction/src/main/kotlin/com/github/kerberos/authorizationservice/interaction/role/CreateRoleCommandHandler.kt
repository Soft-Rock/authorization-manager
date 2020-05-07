package com.github.kerberos.authorizationservice.interaction.role

import com.github.kerberos.authorizationservice.interaction.role.create.CreateRoleCommand
import com.github.kerberos.authorizationservice.librarysource.cqrs.CommandHandler
import java.lang.UnsupportedOperationException

class CreateRoleCommandHandler: CommandHandler<CreateRoleCommand> {
    override fun handle(command: CreateRoleCommand) {
        throw UnsupportedOperationException()
    }
}

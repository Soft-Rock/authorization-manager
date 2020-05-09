package com.github.kerberos.authorizationservice.interaction.role.create

import com.github.kerberos.authorizationservice.interaction.cqrs.Command
import java.util.UUID

data class CreateRoleCommand(
    val id: String = UUID.randomUUID().toString(),
    val description: String,
    val name: String
) : Command

package com.github.kerberos.authorizationservice.interaction.role.create

import com.github.kerberos.authorizationservice.interaction.cqrs.Command

data class CreateRoleCommand(val id: String, val description: String, val name: String) : Command

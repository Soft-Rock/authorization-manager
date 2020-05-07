package com.github.kerberos.authorizationservice.interaction.role.create

import com.github.kerberos.authorizationservice.`library-source`.cqrs.Command

data class CreateRoleCommand(val id: String, val description: String) : Command

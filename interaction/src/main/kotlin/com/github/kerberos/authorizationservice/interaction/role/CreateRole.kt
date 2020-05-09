package com.github.kerberos.authorizationservice.interaction.role

import com.github.kerberos.authorizationservice.domain.role.Role
import com.github.kerberos.authorizationservice.domain.role.RoleDescription
import com.github.kerberos.authorizationservice.domain.role.RoleId
import com.github.kerberos.authorizationservice.domain.role.RoleName
import com.github.kerberos.authorizationservice.interaction.cqrs.CommandHandler
import com.github.kerberos.authorizationservice.interaction.role.create.CreateRoleCommand
import java.util.UUID
import javax.inject.Named

@Named
class CreateRole(
    private val roleRepository: RoleRepository
) : CommandHandler<CreateRoleCommand> {
    override fun handle(command: CreateRoleCommand) {
        command.let {
            Role(
                RoleId(UUID.fromString(command.id)),
                RoleName(it.name),
                RoleDescription(it.description)
            )
        }.let { role ->
            roleRepository.save(role)
        }
    }
}

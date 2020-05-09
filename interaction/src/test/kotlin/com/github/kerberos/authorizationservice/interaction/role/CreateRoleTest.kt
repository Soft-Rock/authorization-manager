package com.github.kerberos.authorizationservice.interaction.role

import com.github.kerberos.authorizationservice.domain.role.Role
import com.github.kerberos.authorizationservice.domain.role.RoleDescription
import com.github.kerberos.authorizationservice.domain.role.RoleId
import com.github.kerberos.authorizationservice.domain.role.RoleName
import com.github.kerberos.authorizationservice.interaction.role.create.CreateRoleCommand
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import java.util.UUID
import org.junit.jupiter.api.Test

internal class CreateRoleTest {
    private val roleRepository: RoleRepository = mockk(relaxed = true)
    private val createRole: CreateRole = CreateRole(roleRepository)

    @Test
    fun `handle command that creates a role by persisting it`() {
        justRun { roleRepository.save(role) }

        createRole.handle(createRoleCommand)

        verify(exactly = 1) {
            roleRepository.save(role)
        }
    }

    companion object {
        private val ID = UUID.randomUUID()
        private const val DESCRIPTION = "School enrolled students"
        private const val NAME = "Student"
        private val roleId = RoleId(ID)
        private val role = Role(
            id = roleId,
            name = RoleName(NAME),
            description = RoleDescription(DESCRIPTION)
        )
        private val createRoleCommand = CreateRoleCommand(
                id = ID.toString(),
                description = DESCRIPTION,
                name = NAME
        )
    }
}

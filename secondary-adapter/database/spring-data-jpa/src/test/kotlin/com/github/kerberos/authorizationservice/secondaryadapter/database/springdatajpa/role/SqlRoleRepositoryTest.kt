package com.github.kerberos.authorizationservice.secondaryadapter.database.springdatajpa.role

import com.github.kerberos.authorizationservice.domain.role.Role
import com.github.kerberos.authorizationservice.domain.role.RoleDescription
import com.github.kerberos.authorizationservice.domain.role.RoleId
import com.github.kerberos.authorizationservice.domain.role.RoleName
import io.mockk.every
import io.mockk.mockk
import java.util.UUID
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.springframework.test.context.ContextConfiguration

// @DataJpaTest
@ContextConfiguration(classes = [JpaRoleRepository::class])
internal class SqlRoleRepositoryTest {
    private val jpaRoleRepository: JpaRoleRepository = mockk()
    private val sqlRoleRepository: SqlRoleRepository = SqlRoleRepository(jpaRoleRepository)

    // @Disabled
    @Test
    fun `save role`() {
        every { jpaRoleRepository.save(stubbedRole) } returns stubbedRole

        val role = sqlRoleRepository.save(expectedRole)

        role `should be equal to` expectedRole
    }

    companion object {
        private val description: RoleDescription = RoleDescription("enrolled student")
        private val name: RoleName = RoleName("student")
        private val roleId: RoleId = RoleId(UUID.randomUUID())
        private val expectedRole: Role = Role(roleId, name, description)
        private val stubbedRole: JpaRole = JpaRole(expectedRole.id.toString(), expectedRole.name.value, expectedRole.description.value)
    }
}

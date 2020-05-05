package com.github.kerberos.authorizationservice.secondaryadapter.database.springdatajpa.role

import com.github.kerberos.authorizationservice.domain.role.Role
import com.github.kerberos.authorizationservice.domain.role.RoleDescription
import com.github.kerberos.authorizationservice.domain.role.RoleId
import com.github.kerberos.authorizationservice.domain.role.RoleName
import java.util.UUID
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
internal class SqlRoleRepositoryTest @Autowired constructor(jpaRoleRepository: JpaRoleRepository) {

    private val sqlRoleRepository: SqlRoleRepository = SqlRoleRepository(jpaRoleRepository)

    @Test
    fun `save role`() {
        val role: Role = sqlRoleRepository.save(expectedRole)

        role `should be equal to` expectedRole
    }

    companion object {
        private val description: RoleDescription = RoleDescription("enrolled student")
        private val name: RoleName = RoleName("student")
        private val roleId: RoleId = RoleId(UUID.randomUUID())
        private val expectedRole: Role = Role(roleId, name, description)
    }
}

package com.github.kerberos.authorizationservice.secondaryadapter.database.springdatajpa.role

import com.github.kerberos.authorizationservice.domain.role.Role
import com.github.kerberos.authorizationservice.domain.role.RoleId
import com.github.kerberos.authorizationservice.interaction.role.RoleRepository
import javax.inject.Named

@Named
class SqlRoleRepository(
    private val jpaRoleRepository: JpaRoleRepository
) : RoleRepository {
    override fun save(role: Role) {
        jpaRoleRepository
        .save(role.toJpaRole())
    }

    override fun findById(roleId: RoleId): Role =
            jpaRoleRepository
                    .findById(roleId.value.toString())
                    .orElse(null)
                    .toRole()
}

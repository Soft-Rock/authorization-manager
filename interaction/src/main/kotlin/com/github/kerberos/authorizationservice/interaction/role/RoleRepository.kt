package com.github.kerberos.authorizationservice.interaction.role

import com.github.kerberos.authorizationservice.domain.role.Role
import com.github.kerberos.authorizationservice.domain.role.RoleId

interface RoleRepository {
    fun save(role: Role): Role
    fun findById(roleId: RoleId): Role
}

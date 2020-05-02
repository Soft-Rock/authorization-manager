package com.github.kerberos.authorizationservice.interaction.role

import com.github.kerberos.authorizationservice.domain.role.Role

interface RoleRepository {
    fun save(role: Role)
}
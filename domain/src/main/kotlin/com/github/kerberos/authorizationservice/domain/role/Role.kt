package com.github.kerberos.authorizationservice.domain.role

import java.util.UUID

data class Role(
    val id: RoleId,
    val name: RoleName,
    val description: RoleDescription
)

data class RoleId(val value: UUID) {
    override fun toString(): String {
        return value.toString()
    }
}
data class RoleName(val value: String)
data class RoleDescription(val value: String)

package com.github.kerberos.authorizationservice.domain

import java.util.UUID

data class Role(
    val id: RoleId,
    val name: RoleName,
    val description: RoleDescription
)

data class RoleId(val value: UUID)
data class RoleName(val value: String)
data class RoleDescription(val value: String)

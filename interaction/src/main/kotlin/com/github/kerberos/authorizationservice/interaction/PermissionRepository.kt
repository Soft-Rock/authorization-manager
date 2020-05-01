package com.github.kerberos.authorizationservice.interaction

import com.github.kerberos.authorizationservice.domain.Permission
import java.util.UUID

interface PermissionRepository {
    fun get(permissionIdentifier: UUID): Permission
    fun put(permissionIdentifier: UUID, permission: Permission)
}

package com.davidgracia.software.authorizationmanager.server.interaction

import com.davidgracia.software.authorizationmanager.server.domain.Permission
import java.util.UUID

interface PermissionRepository {
    fun get(permissionIdentifier: UUID): Permission
    fun put(permissionIdentifier: UUID, permission: Permission)
}

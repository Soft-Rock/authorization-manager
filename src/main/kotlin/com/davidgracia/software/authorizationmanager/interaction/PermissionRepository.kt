package com.davidgracia.software.authorizationmanager.interaction

import com.davidgracia.software.authorizationmanager.domain.Permission
import java.util.*

interface PermissionRepository {
    fun get(permissionIdentifier: UUID): Permission
    fun put(permissionIdentifier: UUID, permission: Permission)
}

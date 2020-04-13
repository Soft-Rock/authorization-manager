package com.davidgracia.software.authorizationmanager.domain

import java.util.*

data class Role(val identifier: UUID, val permissions: Set<Permission>) {
    fun assignPermission(permission: Permission): Role {
        return copy(permissions = this.permissions.plusElement(permission))
    }

    fun assignPermissions(permissions: Set<Permission>): Role {
        return copy(permissions = this.permissions.plus(permissions))
    }

    fun withdrawPermission(permission: Permission): Role {
        return copy(permissions = this.permissions.minus(permission))
    }

    fun withdrawPermissions(permissions: Set<Permission>): Role {
        return copy(permissions = this.permissions.minus(permissions))
    }

    fun hasAssigned(permission: Permission): Boolean {
        return permissions.contains(permission)
    }
}
package com.davidgracia.software.authorizationmanager.domain

data class User(val roles: Set<Role>) {
    fun appointAs(role: Role): User {
        return copy(roles = roles.plusElement(role))
    }

    fun withdrawFrom(role: Role): User {
        return copy(roles = roles.minusElement(role))
    }

    fun hasAssigned(permission: Permission): Boolean {
        return roles.any { role: Role -> role.hasAssigned(permission) }
    }
}
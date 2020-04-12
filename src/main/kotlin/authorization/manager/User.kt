package authorization.manager

import java.util.*

data class User(val identifier: UUID, val roles: Set<Role>) {
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
package authorization.manager

import java.util.*

data class Permission(val identifier: UUID, val description: String) {
    fun setDescription(description: String): Permission {
        return copy(description = description)
    }
}
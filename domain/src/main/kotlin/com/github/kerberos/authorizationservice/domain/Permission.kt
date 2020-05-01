package com.github.kerberos.authorizationservice.domain

data class Permission(val description: String) {
    fun setDescription(description: String): Permission {
        return copy(description = description)
    }
}

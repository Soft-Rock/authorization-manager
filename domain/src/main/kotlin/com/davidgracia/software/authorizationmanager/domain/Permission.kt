package com.davidgracia.software.authorizationmanager.domain

data class Permission(val description: String) {
    fun setDescription(description: String): Permission {
        return copy(description = description)
    }
}
package com.davidgracia.software.authorizationmanager.interaction

import com.davidgracia.software.authorizationmanager.domain.Permission
import java.util.*
import javax.inject.Named
import javax.transaction.Transactional

@Transactional
@Named
open class UpdatePermissionDescriptionCH(private val permissionRepository: PermissionRepository) {
    fun handle(permissionIdentifier: UUID, description: String) {
        permissionRepository.get(permissionIdentifier)
                .let { permission: Permission -> permission.copy(description = description) }
                .let { permission: Permission -> permissionRepository.put(permissionIdentifier, permission) }
    }
}
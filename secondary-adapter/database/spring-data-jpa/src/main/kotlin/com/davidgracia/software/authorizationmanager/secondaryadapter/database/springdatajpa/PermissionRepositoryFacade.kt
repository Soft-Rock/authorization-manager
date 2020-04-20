package com.davidgracia.software.authorizationmanager.secondaryadapter.database.springdatajpa

import com.davidgracia.software.authorizationmanager.domain.Permission
import com.davidgracia.software.authorizationmanager.interaction.PermissionRepository
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class PermissionRepositoryFacade : PermissionRepository {
    override fun get(permissionIdentifier: UUID): Permission {
        TODO("Not yet implemented")
    }

    override fun put(permissionIdentifier: UUID, permission: Permission) {
        TODO("Not yet implemented")
    }
}

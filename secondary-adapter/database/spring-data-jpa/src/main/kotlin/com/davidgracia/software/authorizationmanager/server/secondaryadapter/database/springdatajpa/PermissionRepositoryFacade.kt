package com.davidgracia.software.authorizationmanager.server.secondaryadapter.database.springdatajpa

import com.davidgracia.software.authorizationmanager.server.domain.Permission
import com.davidgracia.software.authorizationmanager.server.interaction.PermissionRepository
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

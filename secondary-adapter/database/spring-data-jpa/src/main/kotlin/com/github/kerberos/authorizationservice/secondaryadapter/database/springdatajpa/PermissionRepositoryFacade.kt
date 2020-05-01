package com.github.kerberos.authorizationservice.secondaryadapter.database.springdatajpa

import com.github.kerberos.authorizationservice.domain.Permission
import com.github.kerberos.authorizationservice.interaction.PermissionRepository
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

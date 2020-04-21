package com.davidgracia.software.authorizationmanager.interaction

import com.davidgracia.software.authorizationmanager.domain.Permission
import io.mockk.every
import io.mockk.mockk
import java.util.UUID
import org.junit.jupiter.api.Test

internal class UpdatePermissionDescriptionCHTest {
    @Test
    fun someTest() {
        val permissionRepository: PermissionRepository = mockk(relaxed = true)

        val permissionIdentifier: UUID = UUID.randomUUID()
        val description = "description"
        every {
            permissionRepository.get(permissionIdentifier)
        } returns Permission(description)

        UpdatePermissionDescriptionCH(permissionRepository = permissionRepository)
                .handle(permissionIdentifier = permissionIdentifier, description = description)
    }
}

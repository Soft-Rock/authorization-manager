package com.davidgracia.software.authorizationmanager.primaryadapter.springwebmvc

import com.davidgracia.software.authorizationmanager.interaction.UpdatePermissionDescriptionCH
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class PermissionPatchController(private val updatePermissionDescriptionCH: UpdatePermissionDescriptionCH) {

    @PatchMapping("/permissions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun patchDescription(@PathVariable id: String, @RequestBody descriptionPermissionRequestPatchBody: DescriptionPermissionRequestPatchBody) {
        updatePermissionDescriptionCH.handle(
                permissionIdentifier = UUID.fromString(id),
                description = descriptionPermissionRequestPatchBody.description
        )
    }
}

data class DescriptionPermissionRequestPatchBody(val description: String)

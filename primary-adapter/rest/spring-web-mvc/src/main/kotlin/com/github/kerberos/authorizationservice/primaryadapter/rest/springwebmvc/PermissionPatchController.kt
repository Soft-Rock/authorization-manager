package com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc

import com.github.kerberos.authorizationservice.interaction.UpdatePermissionDescriptionCH
import java.util.UUID
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

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

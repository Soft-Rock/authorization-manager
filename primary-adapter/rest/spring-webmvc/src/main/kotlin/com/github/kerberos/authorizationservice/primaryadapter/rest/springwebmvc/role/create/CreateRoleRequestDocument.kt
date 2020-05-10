package com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc.role.create

import com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc.jsonapi.ResourceTypes
import com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc.role.create.exceptions.InvalidResourceType

internal class CreateRoleRequestDocument(
    val data: CreateRoleRequestResource
)
internal data class CreateRoleRequestResource(
    val attributes: CreateRoleResourceAttributes,
    val type: String
) {
    init {
        validateResourceType()
    }

    private fun validateResourceType() {
        when {
            type != ResourceTypes.ROLES -> throw InvalidResourceType(type, ResourceTypes.ROLES)
        }
    }
}

internal data class CreateRoleResourceAttributes(
    val name: String,
    val description: String
)

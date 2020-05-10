package com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc.role.create

internal data class CreateRoleRequestDocument(
    val data: CreateRoleRequestResource
)

internal data class CreateRoleRequestResource(
    val attributes: CreateRoleResourceAttributes,
    val type: String
)

internal data class CreateRoleResourceAttributes(
    val name: String,
    val description: String
)

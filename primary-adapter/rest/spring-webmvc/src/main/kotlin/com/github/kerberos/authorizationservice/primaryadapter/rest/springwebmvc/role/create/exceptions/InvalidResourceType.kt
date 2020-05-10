package com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc.role.create.exceptions

class InvalidResourceType(override val message: String) : RuntimeException(message) {
    constructor(
        receivedResourceType: String,
        expectedResourceType: String
    ) : this("The resource type received <$receivedResourceType> does not matches the expected resource type: <$expectedResourceType>")
}

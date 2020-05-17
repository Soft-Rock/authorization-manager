package com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc.jsonapi

data class InvalidJsonApiTypeException(val type: String) : RuntimeException("Invalid JSON:API type: $type")

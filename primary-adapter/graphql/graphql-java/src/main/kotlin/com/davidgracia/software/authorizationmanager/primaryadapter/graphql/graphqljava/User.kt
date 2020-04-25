package com.davidgracia.software.authorizationmanager.primaryadapter.graphql.graphqljava

import com.expediagroup.graphql.annotations.GraphQLDescription

@GraphQLDescription("A User")
data class User(
        @GraphQLDescription("identifier")
        val identifier: String,
        @GraphQLDescription("name")
        val name: String)

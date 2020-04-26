package com.davidgracia.software.authorizationmanager.server.primaryadapter.graphql.graphqljava

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Mutation
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class CreateUser : Mutation {
    @GraphQLDescription("Create User")
    fun createUser(user: UserInput): User {
        return User(UUID.randomUUID().toString(), user.name)
    }
}

data class UserInput(val name: String)

package com.davidgracia.software.authorizationmanager.server.primaryadapter.graphql.graphqljava

import com.expediagroup.graphql.spring.operations.Mutation
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class CreateUser : Mutation {

    fun createUser(user: UserInput): User {
        return User(UUID.randomUUID().toString(), user.externalIdentifier, user.name)
    }
}

data class UserInput(val externalIdentifier: String, val name: String)

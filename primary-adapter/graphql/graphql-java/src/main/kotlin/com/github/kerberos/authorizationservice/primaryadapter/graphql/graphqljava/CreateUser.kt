package com.github.kerberos.authorizationservice.primaryadapter.graphql.graphqljava

import com.expediagroup.graphql.spring.operations.Mutation
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class CreateUser : Mutation {

    fun createUser(user: UserInput): User {
        return User(UUID.randomUUID().toString(), user.externalIdentifier, user.name)
    }
}

data class UserInput(val externalIdentifier: String, val name: String)

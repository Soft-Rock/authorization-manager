package com.davidgracia.software.authorizationmanager.primaryadapter.graphql.graphqljava

import com.expediagroup.graphql.spring.operations.Mutation
import org.springframework.stereotype.Component

@Component
class CreateUser : Mutation {
    fun createUser(user: User): User {
        return user
    }
}

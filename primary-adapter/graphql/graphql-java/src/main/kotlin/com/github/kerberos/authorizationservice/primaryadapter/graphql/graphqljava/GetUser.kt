package com.github.kerberos.authorizationservice.primaryadapter.graphql.graphqljava

import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class GetUser : Query {

    private val users: Map<String, User> = mapOf(
            "1" to User("1", "abc", "Walter White"),
            "2" to User("2", "xyz", "Jesse Pinkman")
    )

    fun getUser(identifier: String): User {
        return users.getValue(identifier)
    }
}

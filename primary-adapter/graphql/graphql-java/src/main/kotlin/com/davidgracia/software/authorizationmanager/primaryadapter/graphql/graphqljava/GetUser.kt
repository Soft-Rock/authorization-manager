package com.davidgracia.software.authorizationmanager.primaryadapter.graphql.graphqljava

import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class GetUser : Query {

    private val users: Map<String, User> = mapOf(
            "1" to User("1", "John"),
            "2" to User("2", "Sonia")
    )

    fun getUser(identifier: String): User {
        return users.getValue(identifier)
    }
}
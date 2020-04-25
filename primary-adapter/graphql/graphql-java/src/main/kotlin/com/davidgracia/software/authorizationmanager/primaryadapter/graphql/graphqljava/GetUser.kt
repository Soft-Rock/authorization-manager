package com.davidgracia.software.authorizationmanager.primaryadapter.graphql.graphqljava

import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class GetUser : Query {
    fun getUser(): User {
        return User("asdasd", "1234567")
    }
}
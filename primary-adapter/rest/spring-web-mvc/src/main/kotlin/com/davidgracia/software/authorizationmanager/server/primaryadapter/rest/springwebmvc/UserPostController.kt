package com.davidgracia.software.authorizationmanager.server.primaryadapter.rest.springwebmvc

import java.util.UUID
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class UserPostController {

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    fun postUser(@RequestBody userRequestPostBody: UserRequestPostBody): UserResponsePostBody {
        return UserResponsePostBody(identifier = UUID.randomUUID().toString(), name = userRequestPostBody.name)
    }
}

data class UserRequestPostBody(val name: String)

data class UserResponsePostBody(val identifier: String, val name: String)

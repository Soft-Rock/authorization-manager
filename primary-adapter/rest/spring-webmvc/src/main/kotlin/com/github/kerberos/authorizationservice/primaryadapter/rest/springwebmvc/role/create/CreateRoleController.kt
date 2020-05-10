package com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc.role.create

import com.github.kerberos.authorizationservice.interaction.cqrs.CommandBus
import com.github.kerberos.authorizationservice.interaction.role.create.CreateRoleCommand
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
internal class CreateRoleController(
    private val commandBus: CommandBus
) {
    @PostMapping("/roles")
    @ResponseStatus(CREATED)
    fun createRole(@RequestBody requestDocument: CreateRoleRequestDocument) {
        commandBus.dispatch(
            CreateRoleCommand(
                name = requestDocument.data.attributes.name,
                description = requestDocument.data.attributes.description
            )
        )
    }
}

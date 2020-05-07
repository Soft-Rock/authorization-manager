package com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc.role.create

import com.github.kerberos.authorizationservice.`library-source`.cqrs.CommandBus
import com.github.kerberos.authorizationservice.interaction.role.create.CreateRoleCommand
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CreateRoleController(
    private val commandBus: CommandBus
) {
    @PostMapping("/api/roles")
    fun createRole(@RequestBody body: CreateRoleBody) {
        commandBus.execute(CreateRoleCommand(body.id, body.description))
    }
}

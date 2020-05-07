package com.github.kerberos.authorizationservice.librarysource.cqrs

import com.github.kerberos.authorizationservice.interaction.role.CreateRoleCommandHandler
import com.github.kerberos.authorizationservice.interaction.role.create.CreateRoleCommand
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import java.util.UUID


internal class SimpleCommandBusTest {
    private val createRoleCommandHandler: CreateRoleCommandHandler = mockk()
    private val simpleCommandBus: SimpleCommandBus = SimpleCommandBus(createRoleCommandHandler)

    @Test
    fun `given a command, should dispatch execution to appropriate handler`() {
        justRun { createRoleCommandHandler.handle(command) }

        simpleCommandBus.dispatch(command)

        verify(exactly = 1) {
            createRoleCommandHandler.handle(command)
        }
    }

    companion object {
        private val command = CreateRoleCommand(
            id = UUID.randomUUID().toString(),
            description = "Student"
        )
    }


}
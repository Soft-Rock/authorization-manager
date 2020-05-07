package com.github.kerberos.authorizationservice.librarysource.cqrs

interface CommandBus {
    fun <C : Command> dispatch(command: C)
}

interface Command

interface CommandHandler<C : Command> {
    fun handle(command: C)
}

interface QueryBus {
    fun <R, Q : Query<R>> execute(query: Q): R
}

interface QueryHandler {
    fun <R, Q : Query<R>> handle(query: Q): R
}

interface Query<R>

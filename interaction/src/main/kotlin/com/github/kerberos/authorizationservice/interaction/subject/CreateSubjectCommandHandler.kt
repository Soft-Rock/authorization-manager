package com.github.kerberos.authorizationservice.interaction.subject

import com.github.kerberos.authorizationservice.domain.subject.Subject
import com.github.kerberos.authorizationservice.domain.subject.SubjectCreator
import java.util.UUID
import javax.inject.Named
import javax.transaction.Transactional

@Named
open class CreateSubjectCommandHandler(private val subjectCreator: SubjectCreator) {
    @Transactional
    open fun handle(command: CreateSubjectCommand): UUID {
        return subjectCreator.create(Subject.ExternalId(command.externalId), Subject.Name(command.name)).uuid
    }
}

data class CreateSubjectCommand(val externalId: String, val name: String)

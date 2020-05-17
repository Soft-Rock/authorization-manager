package com.github.kerberos.authorizationservice.domain.subject

import java.util.UUID
import javax.inject.Named

@Named
class SubjectCreator(private val subjectRepository: SubjectRepository) {
    fun create(externalId: Subject.ExternalId, name: Subject.Name): Subject.Id {
        return Subject(
                id = Subject.Id(UUID.randomUUID()),
                externalId = externalId,
                name = name
        ).let { subjectRepository.save(it) }
    }
}

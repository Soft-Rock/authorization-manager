package com.github.kerberos.authorizationservice.interaction.subject

import com.github.kerberos.authorizationservice.domain.subject.Subject
import com.github.kerberos.authorizationservice.domain.subject.SubjectFinder
import java.util.UUID
import javax.inject.Named

@Named
class FindSubjectQueryHandler(private val subjectFinder: SubjectFinder) {
    fun handle(findSubjectQuery: FindSubjectQuery): FindSubjectQueryResult? {
        return subjectFinder.findById(Subject.Id(findSubjectQuery.subjectId))?.toQueryResult()
    }
}

private fun Subject.toQueryResult(): FindSubjectQueryResult {
    return FindSubjectQueryResult(
            subjectId = id.uuid,
            externalId = externalId.string,
            name = name.string
    )
}

data class FindSubjectQueryResult(val subjectId: UUID, val externalId: String, val name: String)

data class FindSubjectQuery(val subjectId: UUID)

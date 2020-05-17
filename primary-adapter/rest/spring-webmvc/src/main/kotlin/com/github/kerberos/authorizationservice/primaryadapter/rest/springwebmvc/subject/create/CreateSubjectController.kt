package com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc.subject.create

import com.github.kerberos.authorizationservice.interaction.subject.CreateSubjectCommand
import com.github.kerberos.authorizationservice.interaction.subject.CreateSubjectCommandHandler
import com.github.kerberos.authorizationservice.interaction.subject.FindSubjectQuery
import com.github.kerberos.authorizationservice.interaction.subject.FindSubjectQueryHandler
import com.github.kerberos.authorizationservice.interaction.subject.FindSubjectQueryResult
import com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc.HttpConstants.CONTENT_TYPE_KEY
import com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc.jsonapi.InvalidJsonApiTypeException
import com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc.jsonapi.JsonApiConstants.CONTENT_TYPE
import com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc.jsonapi.ResourceTypes.SUBJECTS
import com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc.subject.SubjectConstants
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
internal class CreateSubjectController(
    private val createSubjectCommandHandler: CreateSubjectCommandHandler,
    private val findSubjectQueryHandler: FindSubjectQueryHandler
) {

    @PostMapping(SubjectConstants.PATH)
    fun createSubject(@RequestBody subjectPostRequestDocument: SubjectPostRequestDocument): ResponseEntity<SubjectResponseDocument> {
        return subjectPostRequestDocument
                .toCreateSubjectCommand()
                .let { createSubjectCommandHandler.handle(it) }
                .let { findSubjectQueryHandler.handle(FindSubjectQuery(it)) }
                .let {
                    when (it) {
                        is FindSubjectQueryResult -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .header(CONTENT_TYPE_KEY, CONTENT_TYPE)
                                .body(it.toDocument())
                        null -> ResponseEntity
                                .notFound()
                                .header(CONTENT_TYPE_KEY, CONTENT_TYPE)
                                .build()
                        else -> throw RuntimeException()
                    }
                }
    }
}

private fun FindSubjectQueryResult.toDocument(): SubjectResponseDocument {
    return with(this) {
        SubjectResponseDocument(
                data = SubjectResponseResource(
                        id = subjectId.toString(),
                        attributes = SubjectResponseResourceAttributes(
                                externalId = externalId,
                                name = name
                        )
                )
        )
    }
}

internal data class SubjectPostRequestDocument(val data: SubjectPostRequestResource) {
    fun toCreateSubjectCommand(): CreateSubjectCommand {
        return with(data.attributes) {
            CreateSubjectCommand(
                    externalId = externalId,
                    name = name
            )
        }
    }
}

internal data class SubjectPostRequestResource(
    val attributes: SubjectPostRequestResourceAttributes,
    val type: String
) {
    init {
        if (type != SUBJECTS) throw InvalidJsonApiTypeException(type)
    }
}

internal data class SubjectPostRequestResourceAttributes(val externalId: String, val name: String)

internal data class SubjectResponseDocument(val data: SubjectResponseResource)

internal data class SubjectResponseResource(
    val id: String,
    val attributes: SubjectResponseResourceAttributes
) {
    val type: String = SUBJECTS
}

internal data class SubjectResponseResourceAttributes(
    val externalId: String,
    val name: String
)

package com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc.subject.create

import com.github.kerberos.authorizationservice.domain.subject.Subject
import com.github.kerberos.authorizationservice.interaction.subject.SaveSubjectCommand
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
internal class CreateSubjectController {

    @PostMapping("/subjects")
    @ResponseStatus(HttpStatus.CREATED)
    fun createSubject(@RequestBody subjectRequestPostBody: SubjectPostRequestDocument): SubjectPostResponseDocument {
        return SubjectPostResponseDocument(
                data = SubjectPostResponseResource(
                        id = "xyz",
                        attributes = SubjectPostResponseResourceAttributes(
                                externalIdentifier = "1234",
                                name = "Jack"
                        )
                )
        )
    }
}

internal fun Subject.toDocument(): SubjectPostResponseDocument {
    return SubjectPostResponseDocument(
            data = SubjectPostResponseResource(
                    id = identifier.toString(),
                    attributes = SubjectPostResponseResourceAttributes(
                            externalIdentifier = externalIdentifier,
                            name = name
                    )
            )
    )
}

internal data class SubjectPostRequestDocument(val data: SubjectPostRequestResource) {
    fun toSaveSubjectCommand(): SaveSubjectCommand {
        return SaveSubjectCommand(
                name = data.attributes.name
        )
    }
}

internal data class SubjectPostRequestResource(
        val attributes: SubjectPostRequestResourceAttributes,
        private val type: String = "subjects"
)

internal data class SubjectPostRequestResourceAttributes(
    val name: String
)

internal data class SubjectPostResponseDocument(val data: SubjectPostResponseResource)

internal data class SubjectPostResponseResource(
    val id: String,
    val attributes: SubjectPostResponseResourceAttributes
) {
    val type: String = "subjects"
}

internal data class SubjectPostResponseResourceAttributes(
    val externalIdentifier: String,
    val name: String
)

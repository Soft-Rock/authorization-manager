package com.github.kerberos.authorizationservice.domain.subject

import java.util.UUID

data class Subject(val id: Id, val externalId: ExternalId, val name: Name) {
    data class Id(val uuid: UUID)
    data class ExternalId(val string: String)
    data class Name(val string: String)
}

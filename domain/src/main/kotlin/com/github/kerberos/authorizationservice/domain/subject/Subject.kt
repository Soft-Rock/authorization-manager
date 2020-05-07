package com.github.kerberos.authorizationservice.domain.subject

import java.util.UUID

data class Subject(val identifier: UUID, val externalIdentifier: String, val name: String)

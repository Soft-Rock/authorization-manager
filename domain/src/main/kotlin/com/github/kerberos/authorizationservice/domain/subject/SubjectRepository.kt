package com.github.kerberos.authorizationservice.domain.subject

interface SubjectRepository {
    fun save(subject: Subject): Subject.Id
    fun findById(id: Subject.Id): Subject?
}

package com.github.kerberos.authorizationservice.domain.subject

import javax.inject.Named

@Named
class SubjectFinder(private val subjectRepository: SubjectRepository) {
    fun findById(id: Subject.Id): Subject? {
        return subjectRepository.findById(id)
    }
}

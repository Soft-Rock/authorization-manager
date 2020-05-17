package com.github.kerberos.authorizationservice.secondaryadapter.database.springdatajpa.subject

import com.github.kerberos.authorizationservice.domain.subject.Subject
import com.github.kerberos.authorizationservice.domain.subject.SubjectRepository
import java.util.UUID
import javax.inject.Named
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull

@Named
class DatabaseSubjectRepository(private val jpaSubjectRepository: JpaSubjectRepository) : SubjectRepository {
    override fun save(subject: Subject): Subject.Id {
        return subject.toJpaSubject().let { jpaSubjectRepository.save(it) }.id.toSubjectId()
    }

    override fun findById(id: Subject.Id): Subject? {
        return jpaSubjectRepository.findByIdOrNull(id.uuid.toString())?.toSubject()
    }
}

private fun String.toSubjectId(): Subject.Id {
    return Subject.Id(UUID.fromString(this))
}

private fun Subject.toJpaSubject(): JpaSubject {
    return with(this) {
        JpaSubject(
                id = id.uuid.toString(),
                externalId = externalId.string,
                name = name.string
        )
    }
}

interface JpaSubjectRepository : JpaRepository<JpaSubject, String>

@Entity
@Table(name = "SUBJECT", schema = "PUBLIC")
data class JpaSubject(
    @Id
    val id: String,
    val externalId: String,
    val name: String
) {
    fun toSubject(): Subject {
        return Subject(
                id = Subject.Id(UUID.fromString(id)),
                externalId = Subject.ExternalId(externalId),
                name = Subject.Name(name)
        )
    }
}

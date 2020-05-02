package com.github.kerberos.authorizationservice.secondaryadapter.database.springdatajpa.role

import com.github.kerberos.authorizationservice.domain.role.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Repository
interface JpaRoleRepository : JpaRepository<JpaRole, UUID>

@Entity
@Table(name = "ROLES", schema = "PUBLIC")
class JpaRole(
    @Id
    private val id: String,
    private val name: String,
    private val description: String
) {

}

internal fun Role.toJpaRole() =
    JpaRole(
        id = this.id.toString(),
        name = this.name.value,
        description = this.description.value
    )



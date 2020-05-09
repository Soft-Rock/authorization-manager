package com.github.kerberos.authorizationservice.secondaryadapter.database.springdatajpa.role

import com.github.kerberos.authorizationservice.domain.role.Role
import com.github.kerberos.authorizationservice.domain.role.RoleDescription
import com.github.kerberos.authorizationservice.domain.role.RoleId
import com.github.kerberos.authorizationservice.domain.role.RoleName
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaRoleRepository : JpaRepository<JpaRole, String>

@Entity
@Table(name = "ROLES", schema = "PUBLIC")
data class JpaRole(
    @Id
    private val id: String,
    private val name: String,
    private val description: String
) {
    fun toRole(): Role = Role(
        id = RoleId(UUID.fromString(this.id)),
        name = RoleName(this.name),
        description = RoleDescription(this.description)
    )
}

internal fun Role.toJpaRole() =
    JpaRole(
        id = this.id.toString(),
        name = this.name.value,
        description = this.description.value
    )

package com.github.kerberos.authorizationservice.secondaryadapter.database.springdatajpa.role

import com.github.kerberos.authorizationservice.domain.role.Role
import com.github.kerberos.authorizationservice.domain.role.RoleId
import com.github.kerberos.authorizationservice.interaction.role.RoleRepository
import javax.inject.Named
import javax.persistence.EntityExistsException
import javax.persistence.EntityNotFoundException
import org.springframework.data.repository.findByIdOrNull

@Named
class SqlRoleRepository(
    private val jpaRoleRepository: JpaRoleRepository
) : RoleRepository {
    override fun save(role: Role) {
        if (!jpaRoleRepository.existsById(role.id.toString())) {
            jpaRoleRepository.save(role.toJpaRole())
        } else {
            throw EntityExistsException()
        }
    }

    override fun findById(roleId: RoleId): Role =
            jpaRoleRepository
                    .findByIdOrNull(roleId.value.toString())
                    ?.toRole() ?: throw EntityNotFoundException()
}

package com.github.kerberos.authorizationservice.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PermissionTest {
    @Test
    fun testSomeLibraryMethod() {
        val permission = Permission("description")
        assertThat(permission).isNotNull
    }
}

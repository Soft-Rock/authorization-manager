package com.davidgracia.software.authorizationmanager.domain

import kotlin.test.Test
import kotlin.test.assertNotNull

class PermissionTest {
    @Test fun testSomeLibraryMethod() {
        val permission = Permission("description")
        assertNotNull(permission)
    }
}

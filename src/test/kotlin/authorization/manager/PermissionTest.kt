package authorization.manager

import java.util.*
import kotlin.test.Test
import kotlin.test.assertNotNull

class PermissionTest {
    @Test fun testSomeLibraryMethod() {
        val permission = Permission(UUID.randomUUID(), "description")
        assertNotNull(permission)
    }
}

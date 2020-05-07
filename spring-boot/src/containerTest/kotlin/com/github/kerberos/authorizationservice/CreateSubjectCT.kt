package com.github.kerberos.authorizationservice

import io.restassured.RestAssured
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.path.json.JsonPath
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus

@SpringBootTest(classes = [AuthorizationService::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class CreateSubjectCT {

    @LocalServerPort
    private val port: Int = 0

    @BeforeEach
    fun setUp() {
        RestAssured.port = port
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
    }

    @Test
    @Disabled
    fun `create subject`() {
        Given {
            contentType("application/vnd.api+json")
            body(requestBody)
        } When {
            post("/subjects")
        } Then {
            statusCode(HttpStatus.CREATED.value())
            contentType("application/vnd.api+json")
            body("", Matchers.equalTo(JsonPath(expectedResponseBody)))
        }
    }

    private val name: String = "Jack"
    private val identifier: String = "xyz"
    private val externalIdentifier: String = "1234"

    private val requestBody = """
        {
          "data": {
            "type": "subjects",
            "attributes": {
                "externalIdentifier": "$externalIdentifier",
                "name": "$name"
            }
          }
        }
        """

    private val expectedResponseBody = """
        {
          "data": {
            "id": "$identifier",
            "type": "subjects",
            "attributes": {
                "externalIdentifier": "$externalIdentifier",
                "name": "$name"
            }
          }
        }
        """
}

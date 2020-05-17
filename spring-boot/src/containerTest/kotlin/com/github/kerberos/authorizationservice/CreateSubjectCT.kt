package com.github.kerberos.authorizationservice

import com.github.kerberos.authorizationservice.JsonApiConstants.ATTRIBUTES
import com.github.kerberos.authorizationservice.JsonApiConstants.DATA
import com.github.kerberos.authorizationservice.JsonApiConstants.TYPE
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import io.restassured.RestAssured
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.path.json.JsonPath
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.BeforeEach
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
//    @Disabled
    fun `create subject`() {
        Given {
            contentType(JsonApiConstants.CONTENT_TYPE)
            body(requestBody)
        } When {
            post("/subjects")
        } Then {
            statusCode(HttpStatus.CREATED.value())
            contentType(JsonApiConstants.CONTENT_TYPE)
        } Extract {
            val softAssertions = SoftAssertions()

            with(body().asString()) {
                this.extractType().let { type: String ->
                    softAssertions.assertThat(type).isEqualTo(expectedResponseBody.extractType())
                }

                this.extractAttributes().let { attributes: JsonObject ->
                    softAssertions.assertThat(attributes).isEqualTo(expectedResponseBody.extractAttributes())
                }
            }

            softAssertions.assertAll()
        }
    }

    private fun String.extractType(): String = JsonPath(this).get("$DATA.$TYPE")

    private fun String.extractAttributes(vararg exceptEntries: String): JsonObject {
        return JsonParser
                .parseString(this)
                .asJsonObject
                .getAsJsonObject(DATA)
                .getAsJsonObject(ATTRIBUTES)
                .also { attributes: JsonObject -> exceptEntries.forEach { entry: String -> attributes.remove(entry) } }
    }

    private val name: String = "Jack"
    private val identifier: String = "xyz"
    private val externalId: String = "1234"

    private val requestBody = """
        {
          "data": {
            "type": "subjects",
            "attributes": {
                "externalId": "$externalId",
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
                "externalId": "$externalId",
                "name": "$name"
            }
          }
        }
        """
}

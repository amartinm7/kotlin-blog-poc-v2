package com.amm.poc.blog.infrastructure.framework.user.get.controller

import com.amm.poc.blog.infrastructure.BlogApplication
import com.amm.poc.blog.utls.matchers.JsonMatcher
import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import java.net.HttpURLConnection

private const val EXPECTED_NEW_USER = "/expected/user1.json"

@ActiveProfiles("test")
@SpringBootTest(classes = [BlogApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class CreateUserControllerShould {

    @LocalServerPort
    private var port: Int = 0

    @BeforeEach
    fun setup() {
        RestAssured.port = port
    }

    @Test
    fun `return not found for not valid id`() {
        RestAssured.given()
            .`when`()
            .param("year", "2020")
            .get("/v1/users/notfound")
            .then()
            .statusCode(HttpURLConnection.HTTP_NOT_FOUND)
    }

    @Test
    fun `return a user for a given id`() {
        RestAssured.given()
            .`when`()
            .param("year", "2020")
            .get("/v1/users/1")
            .then()
            .body(JsonMatcher.matchesJson(EXPECTED_NEW_USER))
            .statusCode(HttpURLConnection.HTTP_OK)
    }
}
package com.amm.poc.blog.infrastructure.framework.user.get.controller

import com.amm.poc.blog.infrastructure.framework.IntegrationShould
import com.amm.poc.blog.infrastructure.framework.user.repository.JPADataSource
import com.amm.poc.blog.infrastructure.framework.user.repository.jpa.UserJPA
import com.amm.poc.blog.utls.matchers.JsonMatcher
import com.palantir.docker.compose.DockerComposeExtension
import io.restassured.RestAssured
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import org.springframework.beans.factory.annotation.Autowired
import java.net.HttpURLConnection


private const val EXPECTED_NEW_USER = "/expected/getUser.json"

class GetUserControllerShould : IntegrationShould() {

    @Autowired
    private lateinit var jpaDatasource: JPADataSource

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

        jpaDatasource.save(
            UserJPA(
                id = "1",
                login = "any@gmail.com",
                firstName = "firstName",
                lastName = "lastName",
                description = "any-description"
            )
        )

        RestAssured.given()
            .`when`()
            .param("year", "2020")
            .get("/v1/users/1")
            .then()
            .body(JsonMatcher.matchesJson(EXPECTED_NEW_USER))
            .statusCode(HttpURLConnection.HTTP_OK)
    }
}
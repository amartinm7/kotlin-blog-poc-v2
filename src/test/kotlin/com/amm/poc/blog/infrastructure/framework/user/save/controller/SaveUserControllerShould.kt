package com.amm.poc.blog.infrastructure.framework.user.save.controller

import com.amm.poc.blog.infrastructure.framework.IntegrationShould
import com.amm.poc.blog.utls.matchers.JsonMatcher
import io.restassured.RestAssured
import org.junit.jupiter.api.Test
import java.net.HttpURLConnection

private const val EXPECTED_SAVED_USER = "/expected/savedUser.json"

class SaveUserControllerShould : IntegrationShould() {

    @Test
    fun `save a user given a valid user`() {

        val requestBody = """
        {
          "id": "1",
          "login": "any@gmail.com",
          "firstName": "firstName",
          "lastName": "lastName",
          "description": "any-description"
        }
        """

        RestAssured.given()
            .header("Content-type", "application/json")
            .and()
            .body(requestBody)
            .`when`()
            .post("/v1/users/")
            .then()
            .body(JsonMatcher.matchesJson(EXPECTED_SAVED_USER))
            .statusCode(HttpURLConnection.HTTP_OK)
    }
}
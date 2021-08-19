package com.amm.poc.blog.infrastructure.framework.user.save.controller

import com.amm.poc.blog.infrastructure.framework.IntegrationShould
import io.restassured.RestAssured
import org.junit.jupiter.api.Test
import java.net.HttpURLConnection

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
            .statusCode(HttpURLConnection.HTTP_OK)
    }
}
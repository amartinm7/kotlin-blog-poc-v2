package com.amm.poc.blog.infrastructure.framework

import com.amm.poc.blog.infrastructure.BlogApplication
import com.palantir.docker.compose.DockerComposeExtension
import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.RegisterExtension
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles


@ActiveProfiles("test")
@SpringBootTest(classes = [BlogApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class IntegrationShould {

    @LocalServerPort
    var port: Int = 0

    @BeforeEach
    fun setup() {
        RestAssured.port = port
    }

    companion object {
        @RegisterExtension
        @JvmField
        var docker: DockerComposeExtension = DockerComposeExtension.builder()
            .file("src/test/resources/docker-compose.yml")
            .build()
    }
}
package com.amm.poc.blog.infrastructure.framework.controller.user

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GetUserController : GetUserControllerApiDocumentation {

    @GetMapping("/v1/users/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun process(year: String): ResponseEntity<GetUserControllerResponse> = ResponseEntity.ok(
        GetUserControllerResponse(
            login = "any@gmail.com",
            firstName = "firstname",
            lastName = "lastname",
            description = "any-description",
            id = "1"
        )
    )
}
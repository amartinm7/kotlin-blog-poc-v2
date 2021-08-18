package com.amm.poc.blog.infrastructure.framework.user.controller

import com.amm.poc.blog.application.user.service.GetUserService
import com.amm.poc.blog.application.user.service.GetUserServiceRequest
import com.amm.poc.blog.application.user.service.GetUserServiceResponse
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GetUserController(
    val getUserService: GetUserService
) : GetUserControllerApiDocumentation {

    @GetMapping("/v1/users/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun process(
        @PathVariable id: String,
        year: String
    ): ResponseEntity<GetUserControllerResponse> = ResponseEntity.ok(
        getUserService.execute(GetUserServiceRequest(id)).toResponse()
    )
}

private fun GetUserServiceResponse.toResponse(): GetUserControllerResponse =
    GetUserControllerResponse(
        id,
        login,
        firstName,
        lastName,
        description
    )

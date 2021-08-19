package com.amm.poc.blog.infrastructure.framework.user.save.controller

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SaveUserController : SaveUserControllerApiDocumentation {

    @PostMapping(
        "/v1/users",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    override fun process(@RequestBody userRequestParams: UserRequestParams): ResponseEntity<SaveUserControllerResponse> =
        ResponseEntity.ok(SaveUserControllerResponse(userRequestParams.id))

}

data class SaveUserControllerResponse(val id: String)

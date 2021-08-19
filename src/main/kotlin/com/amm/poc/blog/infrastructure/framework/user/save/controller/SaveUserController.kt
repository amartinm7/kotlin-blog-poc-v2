package com.amm.poc.blog.infrastructure.framework.user.save.controller

import com.amm.poc.blog.application.user.save.service.SaveUserService
import com.amm.poc.blog.application.user.save.service.SaveUserServiceRequest
import com.amm.poc.blog.application.user.save.service.SaveUserServiceResponse
import com.amm.poc.blog.domain.user.User
import com.amm.poc.blog.domain.user.UserId
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SaveUserController(
    private val saveUserService: SaveUserService
) : SaveUserControllerApiDocumentation {

    @PostMapping(
        "/v1/users",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    override fun process(@RequestBody userRequestParams: UserRequestParams): ResponseEntity<SaveUserControllerResponse> =
        saveUserService.execute(userRequestParams.toRequest()).toResponse()

}

private fun SaveUserServiceResponse.toResponse(): ResponseEntity<SaveUserControllerResponse> =
    ResponseEntity.ok(SaveUserControllerResponse(id.value))

private fun UserRequestParams.toRequest(): SaveUserServiceRequest = SaveUserServiceRequest(
    User(
        UserId(id),
        login,
        firstName,
        lastName,
        description
    )
)

data class SaveUserControllerResponse(val id: String)

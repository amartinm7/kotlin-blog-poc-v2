package com.amm.poc.blog.infrastructure.framework.user.save.controller

import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.ResponseEntity

interface SaveUserControllerApiDocumentation {
    @ApiOperation(value = "save user", notes = "save user with all the properties")
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "Successfully retrieved users"),
            ApiResponse(code = 400, message = "Bad request"),
            ApiResponse(code = 500, message = "You broke the server..")
        ]
    )
    fun process(
        UserRequestParams: UserRequestParams
    ): ResponseEntity<SaveUserControllerResponse>
}

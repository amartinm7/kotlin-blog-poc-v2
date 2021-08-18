package com.amm.poc.blog.infrastructure.framework.controller.user

import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.http.ResponseEntity

interface GetUserControllerApiDocumentation {

    @ApiOperation(value = "get user by id", notes = "get user by id and year as query param")
    fun process(
        @ApiParam(value = "year", required = false, example = "?year=2020")
        year: String
    ): ResponseEntity<GetUserControllerResponse>
}

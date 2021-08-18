package com.amm.poc.blog.infrastructure.framework.user.controller

import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable

interface GetUserControllerApiDocumentation {

    @ApiOperation(value = "get user by id", notes = "get user by id and year as query param")
    fun process(
        @ApiParam(value = "id", required = true, example = "1")
        @PathVariable id: String,
        @ApiParam(value = "year", required = false, example = "?year=2020")
        year: String
    ): ResponseEntity<GetUserControllerResponse>
}

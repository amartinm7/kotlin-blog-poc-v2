package com.amm.poc.blog.infrastructure.framework.user.save.controller

import io.swagger.annotations.ApiModelProperty

data class UserRequestParams(
    @ApiModelProperty(example = "1", value = "user id") val id: String,
    @ApiModelProperty(example = "anyuser@gmail.com", value = "login") val login: String,
    @ApiModelProperty(example = "firstName", value = "firstName") val firstName: String,
    @ApiModelProperty(example = "lastName", value = "lastName") val lastName: String,
    @ApiModelProperty(example = "description", value = "description") val description: String
)

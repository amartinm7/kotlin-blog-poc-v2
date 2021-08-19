package com.amm.poc.blog.infrastructure.framework.user.get.controller

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
class GetUserControllerResponse(
    @JsonProperty("id") val id: String,
    @JsonProperty("login") val login: String,
    @JsonProperty("firstName") val firstName: String,
    @JsonProperty("lastName") val lastName: String,
    @JsonProperty("description") val description: String
)
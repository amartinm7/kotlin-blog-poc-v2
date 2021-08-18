package com.amm.poc.blog.application.service.user

class GetUserService {
    fun execute(
        getUserServiceRequest: GetUserServiceRequest
    ): GetUserServiceResponse = GetUserServiceResponse(
        login = "any@gmail.com",
        firstName = "firstname",
        lastName = "lastname",
        description = "any-description",
        id = "1"
    )
}


class GetUserServiceRequest(id: String) {
}

class GetUserServiceResponse(
    val login: String,
    val firstName: String,
    val lastName: String,
    val description: String,
    val id: String
)
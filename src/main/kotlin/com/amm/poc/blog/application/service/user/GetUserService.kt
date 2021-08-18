package com.amm.poc.blog.application.service.user

import com.amm.poc.blog.domain.user.User
import com.amm.poc.blog.domain.user.UserId
import com.amm.poc.blog.domain.user.repository.UserRepository

class GetUserService(
    val userRepository: UserRepository
) {
    fun execute(
        request: GetUserServiceRequest
    ): GetUserServiceResponse =
        userRepository.findById(UserId(request.id)).toResponse()
}

private fun User.toResponse(): GetUserServiceResponse =
    GetUserServiceResponse(
        id.value,
        login,
        firstName,
        lastName,
        description
    )

class GetUserServiceRequest(val id: String)

class GetUserServiceResponse(
    val id: String,
    val login: String,
    val firstName: String,
    val lastName: String,
    val description: String
)
package com.amm.poc.blog.application.user.save.service

import com.amm.poc.blog.domain.user.User
import com.amm.poc.blog.domain.user.repository.UserRepository

class SaveUserService(
    private val userRepository: UserRepository
) {

    fun execute(request: SaveUserServiceRequest) =
        userRepository.save(request.user).toResponse()

}

private fun User.toResponse(): SaveUserServiceResponse = SaveUserServiceResponse(this)

data class SaveUserServiceResponse(val user: User)

data class SaveUserServiceRequest(val user: User)

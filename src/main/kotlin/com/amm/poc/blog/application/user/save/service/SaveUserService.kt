package com.amm.poc.blog.application.user.save.service

import com.amm.poc.blog.domain.user.User
import com.amm.poc.blog.domain.user.UserId

class SaveUserService {

    fun execute(request : SaveUserServiceRequest) =
        SaveUserServiceResponse(request.user.id)
}

data class SaveUserServiceResponse(val id: UserId)

data class SaveUserServiceRequest(val user: User)

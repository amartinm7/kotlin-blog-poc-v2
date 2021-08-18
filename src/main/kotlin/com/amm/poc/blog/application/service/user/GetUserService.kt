package com.amm.poc.blog.application.service.user

class GetUserService {
    fun execute(
        getUserServiceRequest: GetUserServiceRequest
    ): GetUserServiceResponse = GetUserServiceResponse()
}


class GetUserServiceRequest(id: String) {
}

class GetUserServiceResponse
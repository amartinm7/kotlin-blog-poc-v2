package com.amm.poc.blog.infrastructure.framework.user.repository

import com.amm.poc.blog.domain.user.User
import com.amm.poc.blog.domain.user.UserId
import com.amm.poc.blog.domain.user.repository.UserRepository

class UserRepository : UserRepository {
    override fun findById(id: UserId): User =
        User(
            id = UserId("1"),
            login = "any@gmail.com",
            firstName = "firstname",
            lastName = "lastname",
            description = "any-description"
        )
}
package com.amm.poc.blog.infrastructure.framework.user.repository

import com.amm.poc.blog.domain.user.User
import com.amm.poc.blog.domain.user.UserId
import com.amm.poc.blog.domain.user.repository.UserRepository

class UserRepository : UserRepository {

    override fun findById(id: UserId): User? =
        id.value.takeIf { it == "1" }?.let {
            User(
                id = UserId("1"),
                login = "any@gmail.com",
                firstName = "firstname",
                lastName = "lastname",
                description = "any-description"
            )
        }

    override fun save(user: User): UserId = UserId("1")
}

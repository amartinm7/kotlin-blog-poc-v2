package com.amm.poc.blog.infrastructure.framework.user.repository

import com.amm.poc.blog.domain.user.User
import com.amm.poc.blog.domain.user.UserId
import com.amm.poc.blog.domain.user.repository.UserRepository
import com.amm.poc.blog.infrastructure.framework.user.repository.jpa.UserJPA

class UserRepository(
    private val jpaDatasource: JPADataSource
) : UserRepository {

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

    override fun save(user: User): User =
        jpaDatasource.save(user.toJPA()).toUser()
}

private fun UserJPA.toUser(): User = User(
    id = UserId(id),
    login = login,
    firstName = firstName,
    lastName = lastName,
    description = description
)

private fun User.toJPA(): UserJPA =
    UserJPA(
        id = id.value,
        login = login,
        firstName = firstName,
        lastName = lastName,
        description = description
    )

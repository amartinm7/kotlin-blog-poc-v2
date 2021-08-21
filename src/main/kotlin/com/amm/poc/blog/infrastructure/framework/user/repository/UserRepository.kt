package com.amm.poc.blog.infrastructure.framework.user.repository

import com.amm.poc.blog.domain.user.User
import com.amm.poc.blog.domain.user.UserId
import com.amm.poc.blog.domain.user.repository.UserRepository
import com.amm.poc.blog.infrastructure.framework.user.repository.jpa.UserJPA

class UserRepository(
    private val jpaDatasource: JPADataSource
) : UserRepository {

    override fun findById(id: UserId): User? =
        jpaDatasource.findById(id.value).orElse(null)?.toUser()

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

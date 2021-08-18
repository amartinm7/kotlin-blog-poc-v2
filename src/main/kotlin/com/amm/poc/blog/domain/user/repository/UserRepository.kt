package com.amm.poc.blog.domain.user.repository

import com.amm.poc.blog.domain.user.User
import com.amm.poc.blog.domain.user.UserId

interface UserRepository {
    fun findById(id: UserId): User
}

package com.amm.poc.blog.domain.user

data class User(
    val id: UserId,
    val login: String,
    val firstName: String,
    val lastName: String,
    val description: String
)

data class UserId(val value: String)
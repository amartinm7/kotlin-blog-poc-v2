package com.amm.poc.blog.infrastructure.framework.user.repository.jpa

import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "blog_user")
@SuppressWarnings("DataClassShouldBeImmutable")
data class UserJPA(
    @field:Column(name = "id") @Id val id: String,
    @field:Column(name = "login") val login: String,
    @field:Column(name = "first_name") val firstName: String,
    @field:Column(name = "last_name") val lastName: String,
    @field:Column(name = "description") val description: String
){
    @field:UpdateTimestamp
    @field:Column(name = "timestamp")
    lateinit var timestamp: Instant
}

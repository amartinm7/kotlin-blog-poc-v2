package com.amm.poc.blog.infrastructure.framework.configuration

import com.amm.poc.blog.application.user.service.GetUserService
import com.amm.poc.blog.infrastructure.framework.user.repository.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.amm.poc.blog.domain.user.repository.UserRepository as IUserRepository

@Configuration
class UserConfiguration {

    @Bean
    fun getUserService(userRepository: IUserRepository) = GetUserService(userRepository)

    @Bean
    fun userRepository() = UserRepository()
}
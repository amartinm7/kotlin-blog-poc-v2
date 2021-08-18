package com.amm.poc.blog.infrastructure.framework.configuration

import com.amm.poc.blog.application.service.user.GetUserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ServiceConfiguration {

    @Bean
    fun getUserService() = GetUserService()
}
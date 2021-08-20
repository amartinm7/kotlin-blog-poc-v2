package com.amm.poc.blog.infrastructure.framework.user.repository

import com.amm.poc.blog.infrastructure.framework.user.repository.jpa.UserJPA
import org.springframework.data.jpa.repository.JpaRepository

interface JPADataSource : JpaRepository<UserJPA,String> {

}

package com.amm.poc.blog

import com.amm.poc.blog.infrastructure.BlogApplication
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [BlogApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BlogApplicationTests {

	@Test
	fun contextLoads() {
	}

}

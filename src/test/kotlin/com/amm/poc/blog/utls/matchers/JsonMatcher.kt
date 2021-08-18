package com.amm.poc.blog.utls.matchers

import assertk.Assert
import net.javacrumbs.jsonunit.fluent.JsonFluentAssert
import org.hamcrest.BaseMatcher
import org.hamcrest.Description

class JsonMatcher(private val path: String) : BaseMatcher<String>() {
  override fun describeTo(description: Description?) {}
  override fun matches(actual: Any?): Boolean {
    JsonFluentAssert.assertThatJson(actual).isEqualTo(getJsonAsTextFrom(path))
    return true
  }

  private fun getJsonAsTextFrom(path: String) = this.javaClass.getResource(path).readText()

  companion object {
    fun matchesJson(path: String) = JsonMatcher(path)
  }
}


fun Assert<String>.matchesJson(path: String) = given { it ->
  JsonMatcher(path).matches(it)
}

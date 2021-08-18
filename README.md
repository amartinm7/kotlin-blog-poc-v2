![Building web applications with Spring Boot and Kotlin](./_media/kotlin-spring-boot.png)

# Kotlin-blog-v2
taken from spring guide: [Building web applications with Spring Boot and Kotlin](https://spring.io/guides/tutorials/spring-boot-kotlin/)

Springboot Rest API with Kotlin and JPA

### Install gradle wrapper
```bash
gradle wrapper
```
create folders, gradle config files and so on... choose the 8 and 1 options
```bash
./gradlew init
```

Run the app
```bash
./gradlew clean build bootRun
```

Another commands
```bash
gradle init --type java-library
```

```bash
./gradlew compileKotlin
```

Your custom properties should now be recognized when editing application.properties (autocomplete, validation, etc.).
```bash
./gradlew kaptKotlin
```




### Springboot main class
Take care of gradle.build mainClassName, because when a function is not belonging to the class, the mainClassName is called whateverKt with the 'Kt' suffix and the end.
http://engineering.pivotal.io/post/spring-boot-application-with-kotlin/

for
```properties
 mainClassName = 'com.amm.concept.blog.BlogApplication'
```
then
```kotlin
@Springboot
open class BlogApplication {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
           SpringApplication.run(BlogApplication::class.java, *args)
        }
    }
}
```

for
```properties
 mainClassName = 'com.amm.concept.blog.BlogApplicationKt'
```
then
```kotlin
@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class BlogApplication

fun main(args: Array<String>) {
    runApplication<BlogApplication>(*args)
}
```

https://medium.com/@Ankitthakur/spring-boot-with-kotlin-gradle-and-docker-d4e13b60a3d9

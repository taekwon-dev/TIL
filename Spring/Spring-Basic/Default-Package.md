# Default Package

> When a class does not include a `package` declaration, it is considered to be in the “default package”. The use of the “default package” is generally discouraged and should be avoided. It can cause particular problems for Spring Boot applications that use the `@ComponentScan`, `@ConfigurationPropertiesScan`, `@EntityScan`, or `@SpringBootApplication` annotations, since every class from every jar is read.



> We recommend that you follow Java’s recommended package naming conventions and use a reversed domain name (for example, `com.example.project`).



### | Reference

###### https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.structuring-your-code
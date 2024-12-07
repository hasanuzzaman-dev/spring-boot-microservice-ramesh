# Spring WebFlux with WebClient

This guide demonstrates how to configure and use Spring WebFlux's `WebClient` for making non-blocking REST API calls.

---

## Steps to Set Up and Test

### 1. Add Spring WebFlux Dependency

Add the following dependency to your `pom.xml` (for Maven):

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
```

### 2. Configure WebClient as a Spring Bean

```java
@Bean
public WebClient webClient(){
    return WebClient.builder()
            .build();
}
```
### 3. Inject and Use WebClient to Call the REST API
```java
private final WebClient webClient;

@Autowired
public ApiService(WebClient webClient) {
    this.webClient = webClient;
}
```
### 4. Test Using Postman

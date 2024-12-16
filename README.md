# Spring Cloud APIGateWay

This guide demonstrates how to configure and use Spring Cloud APIGateWay for making non-blocking REST API calls.

---

## Steps to Set Up and Test

### 1. Add APIGateWay Dependency

Add the following dependency to your `pom.xml` (for Maven):

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
```
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
```xml
<dependencyManagement>
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-dependencies</artifactId>
        <version>${spring-cloud.version}</version>
        <type>pom</type>
        <scope>import</scope>
    </dependency>
</dependencies>
</dependencyManagement>
```

```xml
<properties>
    <spring-cloud.version>2024.0.0</spring-cloud.version>
</properties>
```
### 2. Enable Eureka Client

```java
@SpringBootApplication
@AutoConfiguration // Enable Eureka Client
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}

```
### 3. Configure in application.yml
```yaml
spring:
  application:
    name: API-GATEWAY

  #Automatic creating route
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true
          lower-case-service-id: true
# Manual creating route
#  cloud:
#    gateway:
#      routes:
#        - id: EMPLOYEE-SERVICE
#          uri: lb://EMPLOYEE-SERVICE
#          predicates:
#            - Path=/api/employees/**
#        - id: DEPARTMENT-SERVICE
#          uri:
#            lb://DEPARTMENT-SERVICE
#          predicates:
#            - Path=/api/departments/**
logging:
  level:
    org:
      springframework:
        cloud:
          gateway:
            handler:
              RoutePredicateHandlerMapping: DEBUG
server:
  port: 9091
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/

management:
  endpoints:
    web:
      exposure:
        include: '*'

```
### 5. API Testing

```url
http://localhost:9091/employee-service/api/employees/1
```

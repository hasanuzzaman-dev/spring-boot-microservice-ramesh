# Spring Cloud CONFIG-SERVER

#### A Config Server in Spring Cloud is a centralized service that manages external configurations for distributed applications across different environments. It allows you to store configuration files in a remote repository (such as Git) and serve them to client applications dynamically.


This guide demonstrates how to configure and use Spring Cloud config-server for making non-blocking REST API calls.

---

## Steps to Set Up and Test

### 1. Create Spring boot project as config-server

### 2. Add config-server Dependency

Add the following dependency to your `pom.xml` (for Maven):

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
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
### 3. Enable config-server
```java
@SpringBootApplication
@EnableConfigServer
public class MyconfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyconfigServerApplication.class, args);
    }
}

```
### 4.Register config server as Eureka Client
Use @AutoConfiguration for enable eureka client and change application.yml
```yaml
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```
### 5. Setup git location for Config Server
```url
https://github.com/hasanuzzaman-dev/config-server1
```
```yaml
spring:
  application:
    name: config-server
  cloud:
    config:
      server:
        git:
          uri: https://github.com/hasanuzzaman-dev/config-server1
          clone-on-start: true
          default-label: main
```
### 6. Refactor other service for config-server
Add the following dependency to your `pom.xml` (for Maven):
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

### 7. create a service-name.yml file in config-server repository and paste configuration
```yaml
server:
  port: 8082

spring:
  application:
    name: DEPARTMENT-SERVICE

  datasource:
    url: jdbc:mysql://localhost:3306/department-service
    username: root
    password: sa123

  jpa:
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQLDialect
    hibernate:
      ddl-auto: update

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/

```

### 8. Comment out all in application.yml file without bellow
```yml
spring:
  application:
    name: DEPARTMENT-SERVICE
  config:
    import: optional:configserver:http://localhost:8888
```

### 9. Refresh use case
We need to call spring boot actuator/refresh api to reload updated values from config server.
```url
http://localhost:8082/message
```
In order to reload the config changes in config client application like (department-service or employee-service) 
We need to trigger /refresh endpoint manually. This is not a viable solution if you have large number of applications.

Spring cloud bus module provides a solution.


### 10. Spring Cloud Bus
#### Spring cloud bus module can be used to link multiple applications with message broker, and we can broadcast configuration changes


# Spring Cloud Bus

#### #### Spring cloud bus module can be used to link multiple applications with message broker, and we can broadcast configuration changes.


This guide demonstrates how to configure and use Spring Cloud Bus for making non-blocking REST API calls.

---

## Steps to Set Up and Test

### 1. Create Spring boot project as Spring Cloud Bus

### 2. Add Spring Cloud Bus Dependency

Add the following dependency to your `pom.xml` (for Maven):

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bus-amqp</artifactId>
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
### 3. Install RabbitMQ using Docker
```java
@SpringBootApplication
@EnableConfigServer
public class MyconfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyconfigServerApplication.class, args);
    }
}

```
### 4. RabbitMQ configuration in application.yml file in services
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

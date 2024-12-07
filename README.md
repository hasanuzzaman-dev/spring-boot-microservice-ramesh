# Spring Cloud OpenFeing

This guide demonstrates how to configure and use Spring Cloud OpenFeing for making non-blocking REST API calls.

---

## Steps to Set Up and Test

### 1. Add OpenFeign Dependency

Add the following dependency to your `pom.xml` (for Maven):

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
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
        <spring-cloud.version>2023.0.4</spring-cloud.version>
</properties>
```
### 2. Enable OpenFeign

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
public class EmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

}

```
### 3. Define a Feign Client Interface
```java
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "DEPARTMENT_SERVICE", url = "http://localhost:8080")
public interface APIClient {

    @GetMapping("/api/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String code);
}

```
### 4. Inject and Use the Feign Client
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    private final ExampleClient exampleClient;

    @Autowired
    public ExampleService(ExampleClient exampleClient) {
        this.exampleClient = exampleClient;
    }

    public String fetchExampleData() {
        return exampleClient.getExampleData();
    }
}
```
### 5. API Testing

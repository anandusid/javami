Spring Boot Actuator provides production-ready features for monitoring and managing Spring Boot applications. It includes a number of built-in endpoints that allow you to interact with your application, gather metrics, understand its state, and perform various management tasks.

### Key Features of Spring Boot Actuator

1. **Health Checks**: Provides endpoints to check the health of your application.
2. **Metrics**: Gathers various metrics related to your application and exposes them through endpoints.
3. **Info**: Displays arbitrary application info.
4. **Audit Events**: Tracks security-related events.
5. **Environment**: Exposes information about your application's environment.

### Getting Started with Spring Boot Actuator

#### Step 1: Add Dependency

First, add the Spring Boot Actuator dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Or if you are using Gradle, add the following to your `build.gradle`:

```groovy
implementation 'org.springframework.boot:spring-boot-starter-actuator'
```

#### Step 2: Enable Endpoints

By default, most Actuator endpoints are secured and not exposed. You can configure which endpoints to expose in your `application.properties` or `application.yml`.

For example, to expose all endpoints:

```properties
management.endpoints.web.exposure.include=*
```

Or to expose specific endpoints:

```properties
management.endpoints.web.exposure.include=health,info
```

#### Step 3: Access Actuator Endpoints

Once Actuator is added and configured, you can access the various endpoints.

- **/actuator/health**: Provides health information.
- **/actuator/info**: Displays arbitrary application info.
- **/actuator/metrics**: Shows metrics.
- **/actuator/env**: Exposes environment properties.
- **/actuator/auditevents**: Displays audit events.

### Example

Here’s a simple example to demonstrate how to use Spring Boot Actuator.

#### Step 1: Create a Spring Boot Application

Create a new Spring Boot application using your favorite IDE or Spring Initializr.

#### Step 2: Add the Actuator Dependency

Add the Actuator dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

#### Step 3: Configure Actuator in `application.properties`

Expose all the Actuator endpoints by adding the following to your `application.properties` file:

```properties
management.endpoints.web.exposure.include=*
```

#### Step 4: Create a REST Controller

Create a simple REST controller to test the Actuator endpoints.

```java
package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
```

#### Step 5: Run the Application

Run your Spring Boot application. Once it is running, you can access the Actuator endpoints.

For example:

- **Health Check**: `http://localhost:8080/actuator/health`
  ```json
  {
    "status": "UP"
  }
  ```
- **Application Info**: `http://localhost:8080/actuator/info`
  (You can configure what information to show by adding `info` properties in `application.properties`.)

- **Metrics**: `http://localhost:8080/actuator/metrics`
  (Provides various application metrics such as memory usage, CPU usage, etc.)

### Securing Actuator Endpoints

In a real-world application, you should secure the Actuator endpoints. This can be done using Spring Security. Here’s a basic example:

#### Step 1: Add Spring Security Dependency

Add the Spring Security dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

#### Step 2: Configure Security

Create a security configuration class to secure the Actuator endpoints.

```java
package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/actuator/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }
}
```

#### Step 3: Define User Roles

Define the users and roles in `application.properties`.

```properties
spring.security.user.name=admin
spring.security.user.password=admin
spring.security.user.roles=ADMIN
```

Now, when you try to access the Actuator endpoints, you will be prompted for a username and password.

### Summary

Spring Boot Actuator is a powerful tool for monitoring and managing your Spring Boot applications. It provides various endpoints to gather metrics, check health, and perform other management tasks. With the addition of Spring Security, you can secure these endpoints to prevent unauthorized access.
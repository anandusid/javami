
Add this in controller:

rabbitTemplate.convertAndSend("compensation.exchange", "compensation.routing.key", storeId);

and create and RabbitMQConfig file in this Service:

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue compensationQueue() {
        return new Queue("compensation.queue", true);
    }

    @Bean
    public DirectExchange compensationExchange() {
        return new DirectExchange("compensation.exchange");
    }

    @Bean
    public Binding compensationBinding(Queue compensationQueue, DirectExchange compensationExchange) {
        return BindingBuilder.bind(compensationQueue).to(compensationExchange).with("compensation.routing.key");
    }
}

And in other service:

RabbitMQCompensationConsumer Listiner


@Component
public class RabbitMQCompensationConsumer {

	@RabbitListener(queues = "compensation.queue")
	@Transactional
	public void compensateOrder(final String sellerId) {
		try {
			System.out.println("delete this order");

		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

Sure, let's break down the code and explain each part in a structured manner:

### Order Service:

1. **`getOrderFromStore` Method**:
   - This method is a controller endpoint (`@GetMapping("/from-store")`) responsible for processing orders received from a store.
   - It takes two parameters: `storeId` and `name`, which are passed as request parameters.
   - Inside a try-catch block, it retrieves the `sellerId` using a Feign client (`storeServiceClient`) by calling `getStoreById`.
   - It creates an `Order` object with the provided `name` and a default `sellerId` of "000".
   - It saves the `Order` object in the database using the repository (`repo.save(obj)`).
   - An intentional division by zero (`final int b = 1 / 0`) is added to simulate an exception and test error handling.

2. **`RabbitMQConfig` Class**:
   - This class is a configuration class responsible for setting up RabbitMQ-related beans.
   - It defines a `compensationQueue`, a `compensationExchange`, and a `compensationBinding` bean.
   - `compensationQueue` represents the queue where compensation messages will be sent.
   - `compensationExchange` represents the exchange to which compensation messages will be sent.
   - `compensationBinding` binds the `compensationQueue` to the `compensationExchange` with a specific routing key.

### Javami Service:

1. **`RabbitMQCompensationConsumer` Class**:
   - This class is a component (`@Component`) responsible for consuming compensation messages from RabbitMQ.
   - It listens to the `compensation.queue` using the `@RabbitListener` annotation.
   - The `compensateOrder` method is invoked whenever a message is received from the queue.
   - Inside a transaction (`@Transactional`), it compensates for the failed order processing by deleting the order from the database.

### Explanation:

- **Error Handling in Order Service**:
  - In case of an exception (division by zero), the `catch` block catches the exception.
  - It sends a compensation message to RabbitMQ using `rabbitTemplate.convertAndSend`.
  - It marks the current transaction for rollback using `TransactionAspectSupport.currentTransactionStatus().setRollbackOnly()`.

- **Compensation Handling in Javami Service**:
  - The `RabbitMQCompensationConsumer` listens to the compensation queue.
  - When a message is received, it compensates by deleting the order from the database.

### Benefits:

- **Fault Tolerance**:
  - If an error occurs during order processing in the Order Service, the system can recover by compensating in the Javami Service.
- **Asynchronous Processing**:
  - The compensation mechanism allows for asynchronous handling of errors without blocking the Order Service.
- **Decoupled Architecture**:
  - RabbitMQ facilitates communication between services, allowing them to operate independently and reducing dependencies.

This structured explanation covers the setup and functionality of RabbitMQ integration for error handling and compensation between the Order and Javami services.

Rabbit MQ scheduler Logic:


create a  Scheduler Component

rabbitTemplate.convertAndSend(order.queue) with annotation: @Scheduled(fixedRate = 3600000)

and then create a component having @RabbitListener(queues = "order.queue")  invoke the api from here.


To invoke your order API once per hour using RabbitMQ, you can set up a scheduled task in your application that sends a message to a RabbitMQ queue at regular intervals. Then, you can have a consumer listening to this queue, which triggers the invocation of your order API whenever a message is received.

Here's a basic outline of how you can implement this:

1. **Producer Side (Scheduler)**: Set up a scheduled task that sends a message to a RabbitMQ queue once per hour.
2. **Consumer Side**: Implement a consumer that listens to the RabbitMQ queue and invokes your order API whenever a message is received.

Let's go through each step in more detail:

### 1. Producer Side (Scheduler)

You can use Spring's `@Scheduled` annotation to schedule a method that sends a message to a RabbitMQ queue at regular intervals.

```java
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderScheduler {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // Schedule the method to run once per hour
    @Scheduled(fixedRate = 3600000) // 1 hour = 3600 seconds * 1000 milliseconds
    public void sendOrderRequest() {
        // Send a message to the RabbitMQ queue
        rabbitTemplate.convertAndSend("order.queue", "Order request message");
    }
}
```

In the above code:
- `OrderScheduler` is a Spring component responsible for scheduling the task.
- The `sendOrderRequest` method is annotated with `@Scheduled` to run once per hour (`fixedRate` of 3600000 milliseconds).
- Inside the method, a message is sent to the RabbitMQ queue named "order.queue".

### 2. Consumer Side

Implement a RabbitMQ consumer that listens to the "order.queue" and triggers the invocation of your order API whenever a message is received.

```java
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestConsumer {

    @Autowired
    private OrderApiClient orderApiClient;

    @RabbitListener(queues = "order.queue")
    public void receiveOrderRequest(String message) {
        // Invoke your order API
        orderApiClient.invokeOrderApi();
    }
}
```

In the above code:
- `OrderRequestConsumer` is a Spring component responsible for consuming messages from the RabbitMQ queue.
- The `receiveOrderRequest` method is annotated with `@RabbitListener` to listen to the "order.queue".
- When a message is received, the `invokeOrderApi` method of `OrderApiClient` (your Feign client for invoking the order API) is called to trigger the invocation of your order API.

### Summary

By setting up a scheduled task on the producer side to send a message to a RabbitMQ queue once per hour and implementing a consumer to listen to this queue and invoke your order API, you can achieve the desired behavior of invoking your order API once per hour. Adjust the scheduling interval (`fixedRate`) in the `OrderScheduler` class as needed to match your requirements.



Certainly! Here's a simple explanation of each component in a typical microservices architecture using Spring Boot and Spring Cloud:

### 1. Configuration Service

- **Purpose:** 
  - Centralized configuration management for all microservices.
  - Provides a single source of truth for application properties across environments.

- **Implementation:**
  - Implemented using Spring Cloud Config Server.
  - Stores configuration files (e.g., application.yml, application.properties) in a Git repository or a file system.
  - Microservices fetch their configuration dynamically from the Config Server at runtime.

- **Dependencies:**
  - `spring-cloud-config-server`: Enables Config Server functionality.
  - `spring-boot-starter-web`: Provides web capabilities for the Config Server.

- **Usage with Other Services:**
  - Microservices access configuration properties (e.g., database URLs, API keys) from the Config Server.
  - Ensures consistency and easy management of configuration across services.

### 2. Eureka Service (Service Registry)

- **Purpose:**
  - Service discovery and registration for microservices.
  - Allows microservices to find and communicate with each other without hard-coded URLs.

- **Implementation:**
  - Implemented using Netflix Eureka (part of Spring Cloud Netflix).
  - Each microservice registers itself with the Eureka server upon startup.
  - Eureka server maintains a registry of available microservices and their locations.

- **Dependencies:**
  - `spring-cloud-starter-netflix-eureka-server`: Enables Eureka server functionality.
  - `spring-boot-starter-web`: Provides web capabilities for the Eureka server.

- **Usage with Other Services:**
  - Microservices use Eureka client to discover other services via logical service names rather than explicit URLs.
  - Facilitates load balancing and failover for microservices.

### 3. API Gateway

- **Purpose:**
  - Single entry point for clients to access multiple microservices.
  - Provides centralized authentication, routing, load balancing, and monitoring.

- **Implementation:**
  - Implemented using Spring Cloud Gateway or Netflix Zuul (though Zuul is now deprecated in favor of Gateway).
  - Routes incoming requests to appropriate microservices based on predefined routes and filters.
  - Can handle cross-cutting concerns like authentication, rate limiting, and logging.

- **Dependencies:**
  - `spring-cloud-starter-gateway` or `spring-cloud-starter-netflix-zuul`: Provides API Gateway capabilities.
  - `spring-boot-starter-web`: Enables web capabilities for the API Gateway.

- **Usage with Other Services:**
  - Clients interact with the API Gateway, which routes requests to the appropriate microservices registered in Eureka.
  - Enables implementing microservices architecture principles such as loose coupling and single responsibility.

### Main Dependencies

- **Spring Boot Starter Dependencies:**
  - `spring-boot-starter-webflux`: For reactive programming and handling non-blocking I/O operations.
  - `spring-boot-starter-security`: Provides security features like authentication and authorization.
  - `spring-boot-starter-data-redis`: Enables integration with Redis for caching and session management.
  - `spring-boot-starter-test`: Provides testing utilities and frameworks for unit and integration testing.

- **Spring Cloud Dependencies:**
  - `spring-cloud-starter-netflix-eureka-client`: Enables microservices to register with and discover other services via Eureka.
  - `spring-cloud-starter-config`: Integrates with Spring Cloud Config Server for externalized configuration management.
  - `spring-cloud-starter-gateway` or `spring-cloud-starter-netflix-zuul`: Implements API Gateway functionality for routing and filtering requests.

### Dependency with Other Services

- **Communication:**
  - Microservices communicate with each other via HTTP/HTTPS protocols.
  - Use RESTful APIs or message brokers (like RabbitMQ or Kafka) for asynchronous communication.
  
- **Security and Authentication:**
  - Utilize OAuth 2.0 for securing APIs and allowing controlled access to resources.
  - JWT tokens are commonly used for authentication and authorization between services and clients.

### Conclusion

In a microservices architecture using Spring Boot and Spring Cloud, the Configuration Service, Eureka Service (Service Registry), and API Gateway play crucial roles in achieving scalability, resilience, and maintainability. They enable efficient communication between microservices, centralized configuration management, and provide a gateway for external clients to access the system. Each component is supported by specific dependencies and integrates closely with other services to form a cohesive and distributed application ecosystem.


In a typical microservices architecture, load balancing is often implemented at the **API Gateway** or **Service Discovery** level. Here’s a breakdown of how load balancing is typically structured in such architectures:

### 1. API Gateway Level:

The API Gateway serves as the entry point for client requests and can perform several functions including:

- **Routing**: Directing incoming requests to the appropriate microservice based on the request URL, headers, or other criteria.
  
- **Load Balancing**: Distributing incoming traffic across multiple instances of a microservice to optimize resource utilization and improve performance.

- **Security**: Implementing authentication, authorization, and encryption for incoming requests.

- **Monitoring and Analytics**: Gathering metrics on request traffic, response times, and service availability.

### 2. Service Discovery Level:

Service Discovery manages the registration, discovery, and health monitoring of microservices within a distributed system. It typically includes:

- **Registration**: Microservices register themselves with the Service Registry (e.g., Eureka, Consul, Zookeeper) upon startup.

- **Discovery**: Clients (other microservices or the API Gateway) query the Service Registry to locate instances of a microservice.

- **Load Balancing**: Service Discovery can provide load balancing capabilities by returning multiple available instances of a microservice in response to client requests.

### Implementation in Spring Cloud:

- **Spring Cloud Netflix Eureka**: Provides a Service Registry and Client-side Load Balancing. Microservices register with Eureka, and other microservices or the API Gateway use Eureka to discover and balance load across instances.

- **Spring Cloud Gateway**: An API Gateway built on Spring WebFlux that can integrate with Eureka for service discovery and Ribbon for client-side load balancing.

### Which Service Handles Load Balancing?

- **API Gateway**: Often, the API Gateway is responsible for load balancing. It receives incoming client requests and uses load balancing algorithms (e.g., Round Robin, Least Connections) to distribute these requests across multiple instances of a microservice.

- **Service Discovery (Eureka)**: In some architectures, especially those using client-side load balancing, the Service Discovery component (like Eureka) also plays a role. It provides the API Gateway or other microservices with a list of available instances, and they handle load balancing at the client side.

### Conclusion:

In your microservices architecture using Spring Boot and Spring Cloud, you typically configure load balancing at the API Gateway (using Spring Cloud Gateway) or leverage client-side load balancing via service discovery (using Eureka and Ribbon). Both approaches ensure that incoming client requests are distributed efficiently across multiple instances of microservices, enhancing scalability, fault tolerance, and overall system performance.

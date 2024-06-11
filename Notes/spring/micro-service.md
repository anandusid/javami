
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

start Zookeper:

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties


start kafka:

.\bin\windows\kafka-server-start.bat .\config\server.properties


/kafka-server-start.sh config/server.properties


javami-topic


bin\windows\kafka-topics.bat --create --topic javami-product-topic --bootstrap-server localhost:9092 --partitions 2 --replication-factor 1


My understanding on kafka:

Producer (Order service )send a message to  a topic (order-create). message will be available in the topic until the expiration date which configured.

Buyer( Consumer-1 in the consumer group (buyer-consumer) ) and Notification (Consumer-1 in the consumer group (noti-consumer) will consume the message from kafka.

Message from the producer will send to the kafka topic's partition and all the messages will be in the queue and will a have unique offset.If suppose 2 partition are there for order-create topic. and if 10 orders where created. all the odd number orders will go to the partion -0 and other even to partition-1. So in buyer and notitification service can consume the message from any partition.

and also i seen one point like muliple consumer from a single consumer group cant access from same partition.

My doubt is how this will happen. in application.yml we specify the group-id and in the listener service we will only specify the topic name . then how multiple consumer will come into picture here.


kafka:
    bootstrap-servers: localhost:9092
    consumer:
      group-id: product-consumer-group
      auto-offset-reset: earliest
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      enable-auto-commit: false
      max-poll-records: 10
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer

@KafkaListener(topics = "javami-topic", groupId = "product-consumer-group")



The `@KafkaListener(topics = "order_topic.DLT", groupId = "dlt-group")` gets invoked automatically because **Spring Kafka**'s `@RetryableTopic` feature manages the creation and redirection of messages to the Dead Letter Topic (DLT) under the hood.

### **How Dead Letter Topic Works in Spring Kafka with `@RetryableTopic`**

When you use the `@RetryableTopic` annotation, it internally manages retry topics and a dead-letter topic. Here's the flow:

1. **Message Consumption**:
   - The main Kafka consumer listens to the `order_topic`.
   - If the consumer processes the message successfully, everything is fine.

2. **Retry Mechanism**:
   - If the consumer throws an exception while processing the message, Spring Kafka automatically moves it to a retry topic (e.g., `order_topic.retry-0`, `order_topic.retry-1`, etc.), based on the number of retries configured.
   - The message is retried according to the specified `attempts` and `backoff` parameters in the `@RetryableTopic` annotation.
   - For example, with `attempts = 3`, the message will be retried 3 times across different retry topics before being considered a failure.

3. **Dead Letter Topic (DLT)**:
   - If all retry attempts are exhausted and the message still fails, it is automatically sent to the Dead Letter Topic.
   - By default, the DLT is named with the suffix `.DLT` (e.g., `order_topic.DLT`).

4. **DLT Listener**:
   - The separate `@KafkaListener` that you define with `topics = "order_topic.DLT"` gets invoked whenever a message ends up in the DLT.
   - This allows you to handle these failed messages differently, such as logging them, sending alerts, or moving them to another storage for manual inspection.

### **Flow Example with Code**

#### **Consumer Service with Retryable Topic**

```java
package com.example.productservice.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.DltStrategy;
import org.springframework.kafka.retrytopic.FixedDelayStrategy;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceConsumer {

    @RetryableTopic(
        attempts = 3,
        backoff = @Backoff(delay = 2000, multiplier = 2.0),  // 2s, 4s, 8s delay between retries
        fixedDelayTopicStrategy = FixedDelayStrategy.SUFFIX,
        dltStrategy = DltStrategy.FAIL_ON_ERROR,
        autoCreateTopics = "true"
    )
    @KafkaListener(topics = "order_topic", groupId = "product-service-group")
    public void consumeOrder(ConsumerRecord<String, String> record) {
        System.out.println("Consumed Order: " + record.value());

        // Simulating a processing failure
        if ("retry".equals(record.value())) {
            throw new RuntimeException("Simulated Failure");
        }
    }

    // This listener is for messages that have failed all retry attempts
    @KafkaListener(topics = "order_topic.DLT", groupId = "dlt-group")
    public void deadLetterTopicConsumer(ConsumerRecord<String, String> record) {
        System.err.println("Dead Letter Received: " + record.value());
        // Handle the failed message here, like saving to DB or alerting
    }
}
```

### **Explanation of the Flow**
1. **Normal Flow**:
   - A message is produced to the `order_topic`.
   - The `consumeOrder` method processes it.
   
2. **Failure and Retry**:
   - If the `consumeOrder` method throws an exception (e.g., when the message value is `"retry"`), the message is retried 3 times with exponential backoff (2s, 4s, 8s).
   - The retries are managed by Spring Kafka, and the message is sent to retry topics like `order_topic.retry-0`, `order_topic.retry-1`, etc.

3. **Dead Letter Handling**:
   - After exhausting all retry attempts, the message is automatically sent to `order_topic.DLT`.
   - The `deadLetterTopicConsumer` method listens on the DLT (`order_topic.DLT`) and processes any messages that end up there.

### **Testing the Flow**
To test the setup:
- Send a message with a value like `"retry"` to the `order_topic`.
- Observe the logs:
  - You should see 3 retry attempts with delays.
  - After retries are exhausted, the message should appear in the Dead Letter Topic and be processed by `deadLetterTopicConsumer`.

### **Summary**
- The `.DLT` topic is automatically created and managed by Spring Kafka when using `@RetryableTopic`.
- You don't need to manually configure the `.DLT` listener beyond defining it with `@KafkaListener`.
- This setup ensures fault tolerance and provides a mechanism to handle permanently failed messages separately.

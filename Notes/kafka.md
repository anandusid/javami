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

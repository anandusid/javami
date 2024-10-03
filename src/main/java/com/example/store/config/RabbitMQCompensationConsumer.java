//package com.example.store.config;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//@Component
//public class RabbitMQCompensationConsumer {
//
//	@RabbitListener(queues = "compensation.queue")
//	@Transactional
//	public void compensateOrder(final String sellerId) {
//		try {
//			System.out.println("delete this order");
//
//		} catch (final Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//}

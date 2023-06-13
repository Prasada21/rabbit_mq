package com.ttechlab.springboot.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.ttechlab.springboot.dto.User;

@Service
public class RabbitMQJsonConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

	@RabbitListener(queues = { "${rabbitmq.queue.json.name}" })
	public void consume(User user) {
		LOGGER.info(String.format("Recieved Json message ->%s", user.toString()));
	}

}
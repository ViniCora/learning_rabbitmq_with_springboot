package br.fiscaltech.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import br.fiscaltech.dto.User;
import br.fiscaltech.producer.RabbitMQProducer;

@Service
public class RabbitMQJsonConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);
	
	@RabbitListener(queues = {"${value.queue.json.name}"})
	public void consume(User message) {
		LOGGER.info(String.format("Recieved: %s", message));
	}
}

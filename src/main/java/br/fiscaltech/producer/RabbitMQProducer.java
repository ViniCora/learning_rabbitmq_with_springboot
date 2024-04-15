package br.fiscaltech.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
	
	@Value("${value.exchange.name}")
	private String exchange;
	
	@Value("${value.routing.key}")
	private String routingKey;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);
	
	private RabbitTemplate rabbitTemplate;

	public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
		this.setRabbitTemplate(rabbitTemplate);
	}
	
	public RabbitTemplate getRabbitTemplate() {
		return rabbitTemplate;
	}
	
	public void sendMessage(String message) {
		LOGGER.info(String.format("Message sent -> %s", message));
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
	}
}

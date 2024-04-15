package br.fiscaltech.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.fiscaltech.dto.User;

@Service
public class RabbitMQJsonProducer {
	@Value("${value.exchange.name}")
	private String exchange;
	
	@Value("${value.routing.json.key}")
	private String routingJsonKey;
	
	private RabbitTemplate rabbitTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

	public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendJsonMessage(User user){
		LOGGER.info(String.format("Producing json: %s", user.toString()));
		rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
	}
	
}

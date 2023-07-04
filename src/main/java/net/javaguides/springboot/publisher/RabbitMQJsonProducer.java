package net.javaguides.springboot.publisher;

import net.javaguides.springboot.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String jsonRoutingKey;

    private RabbitTemplate rabbitTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);
    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(List<User> user) {
//        LOGGER.info(String.format("Json message sent -> %s", user.toString()));
        user.forEach(u -> LOGGER.info(String.format("Json message sent -> %s", u.toString())));
        rabbitTemplate.convertAndSend(exchange, jsonRoutingKey, user);
    }

}

package net.javaguides.springboot.consumer;

import net.javaguides.springboot.dto.User;
import net.javaguides.springboot.publisher.RabbitMQJsonProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(List<User> user) {
//        LOGGER.info(String.format("Received json message -> %s", user.toString()));
        user.forEach(u -> LOGGER.info(String.format("Received json message -> %s", u.toString())));
    }

}
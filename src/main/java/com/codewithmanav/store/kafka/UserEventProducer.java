package com.codewithmanav.store.kafka;

import com.codewithmanav.store.model.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserEventProducer {

    private static final String TOPIC = "user-events";

    private final KafkaTemplate<String, User> kafkaTemplate;

    public UserEventProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserCreatedEvent(User user) {
        kafkaTemplate.send(TOPIC, user);
    }
}

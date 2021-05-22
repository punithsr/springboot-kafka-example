package com.example.kafa.springboot.service.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerImpl {

    private static final Logger log = LoggerFactory.getLogger(ConsumerImpl.class);

    @KafkaListener(topics = "test", groupId = "group-id")
    public void readMessage(final String message) {
        log.info(String.format("**** Consumed message ****-> %s", message));
    }
}

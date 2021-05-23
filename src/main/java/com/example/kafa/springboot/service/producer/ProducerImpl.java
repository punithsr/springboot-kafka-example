package com.example.kafa.springboot.service.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProducerImpl {

    private static final Logger log = LoggerFactory.getLogger(ProducerImpl.class);

    @Value(value="${spring.kafka.topic}")
    private String TOPIC;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerImpl(final KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(final String message) {
        log.info(String.format("**** Producing message ****-> %s", message));
        kafkaTemplate.send(TOPIC, message);
    }
}

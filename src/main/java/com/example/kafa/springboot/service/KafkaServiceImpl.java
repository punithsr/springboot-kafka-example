package com.example.kafa.springboot.service;

import com.example.kafa.springboot.service.consumer.KafkaConsumer;
import com.example.kafa.springboot.service.producer.KafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaServiceImpl {

    private final KafkaProducer kafkaProducer;

    public KafkaServiceImpl(final KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessage(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
    }
}

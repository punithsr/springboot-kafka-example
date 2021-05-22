package com.example.kafa.springboot.service;

import com.example.kafa.springboot.service.producer.ProducerImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class ServiceController {

    private final ProducerImpl producer;

    public ServiceController(final ProducerImpl producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessage(final @RequestParam("message") String message) {
        producer.sendMessage(message);
    }
}

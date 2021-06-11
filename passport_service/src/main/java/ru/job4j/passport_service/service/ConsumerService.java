package ru.job4j.passport_service.service;

import ru.job4j.passport_service.domain.Passport;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @KafkaListener(topics = "passport")
    @Payload(required = false)
    public void printMessage(ConsumerRecord<String, Passport> input) {
        System.out.println(input.value());
    }
}

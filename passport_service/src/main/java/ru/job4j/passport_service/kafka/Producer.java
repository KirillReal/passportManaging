package ru.job4j.passport_service.kafka;

import org.springframework.stereotype.Service;

@Service
public class Producer {
    public String sendMessage(String message) {
        return "Message send to listener";
    }
}

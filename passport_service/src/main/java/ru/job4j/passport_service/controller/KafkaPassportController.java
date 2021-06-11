package ru.job4j.passport_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.passport_service.service.PassportServiceAPI;


@Controller
public class KafkaPassportController {

    @Autowired
    private PassportServiceAPI service;

    @GetMapping
    public String checkPassports() {
        service.checkPassportByDate();
        return "Passport check and send";
    }
}

package ru.job4j.passport_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.passport_service.domain.Passport;
import ru.job4j.passport_service.service.PassportServiceAPI;

import java.util.List;

@RestController
@RequestMapping("/")
public class PassportController {
    private final PassportServiceAPI passportService;

    public PassportController(PassportServiceAPI passportService) {
        this.passportService = passportService;
    }

    @PostMapping
    public ResponseEntity<Passport> save(@RequestBody Passport passport) {
        return new ResponseEntity<>(this.passportService.save(passport), HttpStatus.CREATED);
    }

    @PostMapping("/edit")
    public ResponseEntity<Passport> update(@RequestParam Integer id, @RequestBody Passport passport) {
        if (id == null || passport == null) {
            throw new IllegalStateException();
        }
        passport.setId(id);
        return new ResponseEntity<>(this.passportService.update(passport), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Integer id) {
        if (id == null) {
            throw new IllegalStateException();
        }
        this.passportService.delete(new Passport(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find")
    public List<Passport> find() {
        return this.passportService.find();
    }

    @GetMapping("/unavailable")
    public List<Passport> unavailable() {
        return this.passportService.findUnavaliabe();
    }

    @GetMapping("/find-replaceable")
    public List<Passport> findReplaceable() {
        return this.passportService.findReplaceable();
    }

    @GetMapping("/findBySeries")
    public List<Passport> findBySeries(String series) {
        return this.passportService.findBySeries(series);
    }

}

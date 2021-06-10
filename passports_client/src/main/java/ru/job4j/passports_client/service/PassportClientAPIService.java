package ru.job4j.passports_client.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.passports_client.model.Passport;

import java.util.List;

@Service
public class PassportClientAPIService {
    @Value("${api-url}")
    private String url;

    private final RestTemplate client;

    public PassportClientAPIService(RestTemplate client) {
        this.client = client;
    }

    public Passport save(@NonNull Passport passport) {
        return client.postForEntity(
                String.format(
                        "%s/save", url
                ), passport, Passport.class
        ).getBody();
    }

    public Passport update(@NonNull Passport passport) {
        return client.postForEntity(
                String.format(
                        "%s/update?id=%s", url, passport.getId()
                ), passport, Passport.class
        ).getBody();
    }

    public void delete(@NonNull Passport passport) {
        client.postForEntity(
                String.format(
                        "%s/delete?id=%s", url, passport.getId()
                ), passport, Passport.class
        );
    }

    public List<Passport> find() {
        return client.exchange(
                String.format(
                        "%s/find", url
                ), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Passport>>() {
                }
        ).getBody();
    }

    public List<Passport> findBySeries(String seria) {
        return client.exchange(
                String.format(
                        "%s/find?seria=%s", url, seria
                ), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Passport>>() {
                }
        ).getBody();
    }

    public List<Passport> findUnavaliabe() {
        return client.exchange(
                String.format(
                        "%s/unavaliabe", url
                ), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Passport>>() {
                }
        ).getBody();
    }

    public List<Passport> findReplaceable() {
        return client.exchange(
                String.format(
                        "%s/find-replaceable", url
                ), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Passport>>() {
                }
        ).getBody();
    }
}

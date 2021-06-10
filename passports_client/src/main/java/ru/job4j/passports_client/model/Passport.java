package ru.job4j.passports_client.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Passport {
    private Integer id;

    private String name;
    private String second_name;
    private String sex;
    @JsonFormat(pattern="dd.MM.yyyy")
    private Date birthday;
    @JsonFormat(pattern="dd.MM.yyyy")
    private Date expire;
    private String series;
    private String number;

    public Passport(Integer id) {
        this.id = id;
    }

    public Passport() {
    }
}

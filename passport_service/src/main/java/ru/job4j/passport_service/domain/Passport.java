package ru.job4j.passport_service.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "passports")
@Data
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
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

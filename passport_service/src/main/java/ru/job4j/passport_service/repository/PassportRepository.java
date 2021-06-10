package ru.job4j.passport_service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.passport_service.domain.Passport;

import java.util.Date;
import java.util.List;

public interface PassportRepository extends CrudRepository<Passport, Integer> {
    @Query("select s from #{#entityName} s where s.series = ?1")
    List<Passport> findBySeries(String series);

    @Query("select s from #{#entityName} s where s.expire < CURRENT_DATE")
    List<Passport> findUnavaliabe();

    @Query("select s from #{#entityName} s where s.expire < ?1")
    List<Passport> findReplaceable(Date replaceDate);
}

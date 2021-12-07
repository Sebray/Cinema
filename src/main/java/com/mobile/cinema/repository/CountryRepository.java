package com.mobile.cinema.repository;

import com.mobile.cinema.entity.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {
    List<Country> findAll();
}

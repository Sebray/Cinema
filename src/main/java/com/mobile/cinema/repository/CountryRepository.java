package com.mobile.cinema.repository;

import com.mobile.cinema.entity.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}

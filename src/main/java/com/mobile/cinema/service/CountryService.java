package com.mobile.cinema.service;

import com.mobile.cinema.dto.PageDto;
import com.mobile.cinema.entity.Country;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CountryService {
    List<Country> getCountries();
}

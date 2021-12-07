package com.mobile.cinema.serviceimpl;

import com.mobile.cinema.entity.Country;
import com.mobile.cinema.repository.CountryRepository;
import com.mobile.cinema.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Override
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }
}

package com.mobile.cinema.controller;

import com.mobile.cinema.dto.PageDto;
import com.mobile.cinema.entity.Account;
import com.mobile.cinema.entity.Country;
import com.mobile.cinema.service.AccountService;
import com.mobile.cinema.service.CountryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<Iterable<Country>> getCountries() {
        Iterable<Country> countries = countryService.getCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
}
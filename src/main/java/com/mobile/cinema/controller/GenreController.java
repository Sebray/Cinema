package com.mobile.cinema.controller;

import com.mobile.cinema.dto.PageDto;
import com.mobile.cinema.entity.Account;
import com.mobile.cinema.entity.Country;
import com.mobile.cinema.entity.Genre;
import com.mobile.cinema.service.AccountService;
import com.mobile.cinema.service.CountryService;
import com.mobile.cinema.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public ResponseEntity<Iterable<Genre>> getGenres() {
        Iterable<Genre> genres = genreService.getGenres();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }
}
package com.mobile.cinema.controller;

import com.mobile.cinema.dto.PageDto;
import com.mobile.cinema.entity.BuyingFilms;
import com.mobile.cinema.model.BuyingFilmsModel;
import com.mobile.cinema.service.BuyingFilmsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/buying_films")
public class BuyingFilmsController {
    private final BuyingFilmsService buyingFilmsService;
    @PostMapping
    public ResponseEntity<BuyingFilms> addBuyingFilm(@RequestBody BuyingFilmsModel buyingFilmsModel) {
        return new ResponseEntity<>(buyingFilmsService.addBuyingFilm(buyingFilmsModel), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<BuyingFilms>> getBuyingFilmsById(@RequestParam Long accountId, PageDto pageDto) {
        return new ResponseEntity<>(buyingFilmsService.getFilmsByAccountId(accountId, pageDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BuyingFilms> updateBuyingFilm(@RequestBody BuyingFilms buyingFilms) {
        return new ResponseEntity<>(buyingFilmsService.updateBuyingFilm(buyingFilms), HttpStatus.OK);
    }
}

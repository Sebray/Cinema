package com.mobile.cinema.controller;

import com.mobile.cinema.dto.PageDto;
import com.mobile.cinema.entity.Film;
import com.mobile.cinema.model.FilmModel;
import com.mobile.cinema.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@AllArgsConstructor
@Controller
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        return new ResponseEntity<>(filmService.getFilmById(id), HttpStatus.OK);
    }

    @GetMapping("/country/{id}")
    public ResponseEntity<Page<Film>> getFilmsByCountry(@PathVariable Long id, PageDto pageDto) {
        return new ResponseEntity<>(filmService.getFilmsByCountry(id, pageDto), HttpStatus.OK);
    }

    @GetMapping("/age_rating/{id}")
    public ResponseEntity<Page<Film>> getFilmsByAgeRating(@PathVariable Long id, PageDto pageDto) {
        return new ResponseEntity<>(filmService.getFilmsByAgeRating(id, pageDto), HttpStatus.OK);
    }

    @GetMapping("/genre/{id}")
    public ResponseEntity<Page<Film>> getFilmsByGenre(@PathVariable Long id, PageDto pageDto) {
        return new ResponseEntity<>(filmService.getFilmsByGenre(id, pageDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Film>> getFilms(PageDto pageDto) {
        return new ResponseEntity<>(filmService.getFilms(pageDto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Film> addFilm(@RequestBody FilmModel filmModel) {
        return new ResponseEntity<>(filmService.addFilm(filmModel), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Film> updateFilm(@RequestBody Film film) {
        return new ResponseEntity<>(filmService.updateFilm(film), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        filmService.deleteById(id);
    }

}

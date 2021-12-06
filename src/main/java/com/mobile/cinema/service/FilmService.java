package com.mobile.cinema.service;

import com.mobile.cinema.dto.PageDto;
import com.mobile.cinema.entity.Country;
import com.mobile.cinema.entity.Film;
import com.mobile.cinema.entity.Genre;
import com.mobile.cinema.model.AccountModel;
import com.mobile.cinema.model.FilmModel;
import org.springframework.data.domain.Page;

public interface FilmService {
    Film getFilmById(Long id);

    Page<Film> getFilms(PageDto pageDto);

    Page<Film> getFilmsByCountry(Long countryId, PageDto pageDto);

    Page<Film> getFilmsByGenre(Long genreId, PageDto pageDto);

    Film addFilm(FilmModel filmModel);

    Film updateFilm(Film film);

    void deleteById(Long id);
}

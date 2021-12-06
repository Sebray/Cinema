package com.mobile.cinema.serviceimpl;

import com.mobile.cinema.dto.PageDto;
import com.mobile.cinema.entity.*;
import com.mobile.cinema.exception.ResourceAlreadyExistsException;
import com.mobile.cinema.exception.ResourceNotFoundException;
import com.mobile.cinema.model.FilmModel;
import com.mobile.cinema.repository.*;
import com.mobile.cinema.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {
    FilmRepository filmRepository;
    CountryRepository countryRepository;
    GenreRepository genreRepository;
    BuyingFilmsRepository buyingFilmsRepository;

    @Override
    public Film getFilmById(Long id) {
        return filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "The film with id =" + id + " does not exist."
        ));
    }

    @Override
    public Page<Film> getFilms(PageDto pageDto) {
        return filmRepository.findAll(pageDto.getPageable());
    }

    @Override
    public Page<Film> getFilmsByCountry(Long countryId, PageDto pageDto) {
        if(!countryRepository.existsById(countryId))
            throw new ResourceNotFoundException(
                        "The country with id=" + countryId + " does not exist.");

        return filmRepository.findAllByCountryId(countryId, pageDto.getPageable());
    }

    @Override
    public Page<Film> getFilmsByGenre(Long genreId, PageDto pageDto) {
        if(!genreRepository.existsById(genreId))
            throw new ResourceNotFoundException(
                    "The genre with id=" + genreId + " does not exist.");

        return filmRepository.findAllByGenreId(genreId, pageDto.getPageable());
    }

    @Override
    public Film addFilm(FilmModel filmModel) {
        Country country = countryRepository
                .findById(filmModel.getCountryId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The country with id=" + filmModel.getCountryId() + " does not exist."));

        Genre genre = genreRepository
                .findById(filmModel.getGenreId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The genre with id=" + filmModel.getGenreId() + " does not exist."));

        if (filmRepository.existsByNameAndDate(filmModel.getName(), filmModel.getDate())) {
            throw new ResourceAlreadyExistsException("The film with such name and date already exists.");
        }
        Film film = new Film(filmModel.getName(), filmModel.getPrice(),
                filmModel.getDate(), genre, country);
        filmRepository.save(film);
        return film;
    }

    @Override
    public Film updateFilm(Film film) {
        if (!filmRepository.existsByNameAndDate(film.getName(), film.getDate())) {
            throw new ResourceNotFoundException("The film with name=" + film.getName() + " and date=" + film.getDate() + " does not exist.");
        }
        filmRepository.save(film);
        return film;
    }

    @Override
    public void deleteById(Long id) {
        if (!filmRepository.existsById(id))
            throw new ResourceNotFoundException("The film with id=" + id + " does not exist.");

        buyingFilmsRepository.deleteAllByFilm_Id(id);
        filmRepository.deleteById(id);
    }
}

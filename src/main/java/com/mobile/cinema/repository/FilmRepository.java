package com.mobile.cinema.repository;

import com.mobile.cinema.dto.PageDto;
import com.mobile.cinema.entity.Country;
import com.mobile.cinema.entity.Film;
import com.mobile.cinema.entity.Genre;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface FilmRepository extends JpaRepository<Film, Long> {
    Page<Film> findAllByCountryId(Long countryId, Pageable pageable);

    Page<Film> findAllByGenreId(Long genreId, Pageable pageable);

    boolean existsByNameAndDate(String name, Date date);
}

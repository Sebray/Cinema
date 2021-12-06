package com.mobile.cinema.repository;

import com.mobile.cinema.entity.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}

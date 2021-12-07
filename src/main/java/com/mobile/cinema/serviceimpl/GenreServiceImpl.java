package com.mobile.cinema.serviceimpl;

import com.mobile.cinema.entity.Genre;
import com.mobile.cinema.repository.GenreRepository;
import com.mobile.cinema.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Override
    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }
}

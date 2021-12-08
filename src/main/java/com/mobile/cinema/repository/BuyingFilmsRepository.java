package com.mobile.cinema.repository;

import com.mobile.cinema.entity.BuyingFilmsId;
import com.mobile.cinema.entity.Account;
import com.mobile.cinema.entity.Film;
import com.mobile.cinema.entity.BuyingFilms;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyingFilmsRepository extends JpaRepository<BuyingFilms, BuyingFilmsId> {
    Page<BuyingFilms> findAllByAccount_Id(Long accountId, Pageable pageDto);
    void deleteAllByFilm_Id(Long filmId);
    void deleteAllByAccount_Id(Long accountId);
    void removeAllByFilm_Id(Long filmId);
    boolean existsByAccountAndFilm(Account account, Film film);
}

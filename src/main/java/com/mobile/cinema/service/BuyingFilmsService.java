package com.mobile.cinema.service;

import com.mobile.cinema.dto.PageDto;
import com.mobile.cinema.entity.BuyingFilms;
import com.mobile.cinema.model.BuyingFilmsModel;
import org.springframework.data.domain.Page;

public interface BuyingFilmsService {
    Page<BuyingFilms> getFilmsByAccountId(Long accountId, PageDto pageDto);

    BuyingFilms addBuyingFilm(BuyingFilmsModel buyingFilmsModel);

    BuyingFilms updateBuyingFilm(BuyingFilms buyingFilm);
}

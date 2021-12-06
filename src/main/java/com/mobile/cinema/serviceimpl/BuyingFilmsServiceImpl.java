package com.mobile.cinema.serviceimpl;

import com.mobile.cinema.dto.PageDto;
import com.mobile.cinema.entity.*;
import com.mobile.cinema.exception.PaymentFailedException;
import com.mobile.cinema.exception.ResourceAlreadyExistsException;
import com.mobile.cinema.exception.ResourceNotFoundException;
import com.mobile.cinema.model.BuyingFilmsModel;
import com.mobile.cinema.repository.AccountRepository;
import com.mobile.cinema.repository.FilmRepository;
import com.mobile.cinema.repository.BuyingFilmsRepository;
import com.mobile.cinema.service.BuyingFilmsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class BuyingFilmsServiceImpl implements BuyingFilmsService {
    @PersistenceContext
    protected EntityManager entityManager;
    BuyingFilmsRepository buyingFilmsRepository;
    AccountRepository accountRepository;
    FilmRepository filmRepository;

    @Override
    public Page<BuyingFilms> getFilmsByAccountId(Long accountId, PageDto pageDto) {
        if(!accountRepository.existsById(accountId))
            throw new ResourceNotFoundException(
                    "The account with id=" + accountId + " does not exist.");

        return buyingFilmsRepository.findAllByAccount_Id(accountId, pageDto.getPageable());
    }

    @Override
    public BuyingFilms addBuyingFilm(BuyingFilmsModel buyingFilmsModel) {
        Account account = accountRepository
                .findById(buyingFilmsModel.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The account with id=" + buyingFilmsModel.getAccountId() + " does not exist."));

        Film film = filmRepository
                .findById(buyingFilmsModel.getFilmId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The film with id=" + buyingFilmsModel.getFilmId() + " does not exist."));

        if (account.getBalance() < film.getPrice())
                throw new PaymentFailedException(
                        "The account balance =" + account.getBalance() +" is lesser than price of the film=" + film.getPrice());
        else
            account.setBalance(account.getBalance() - film.getPrice());

        accountRepository.save(account);

        if (buyingFilmsRepository.existsByAccountAndFilm(account, film)) {
            throw new ResourceAlreadyExistsException("The account with id=" + account.getId() + " already bought the film with id=" +
                    film.getId());
        }
        BuyingFilms buyingFilms = new BuyingFilms(film, account,
                buyingFilmsModel.getDate());
        buyingFilmsRepository.save(buyingFilms);
        return buyingFilms;
    }

    @Override
    public BuyingFilms updateBuyingFilm(BuyingFilms buyingFilm) {
        if (!buyingFilmsRepository.existsByAccountAndFilm(buyingFilm.getAccount(), buyingFilm.getFilm())) {
            throw new ResourceNotFoundException("The account with id=" + buyingFilm.getAccount().getId() + "did not buy the film with id=" +
                    buyingFilm.getFilm() + ".");
        }
        buyingFilmsRepository.save(buyingFilm);
        return buyingFilm;
    }
}

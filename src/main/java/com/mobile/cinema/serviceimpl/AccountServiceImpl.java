package com.mobile.cinema.serviceimpl;

import com.mobile.cinema.dto.PageDto;
import com.mobile.cinema.entity.Country;
import com.mobile.cinema.entity.Account;
import com.mobile.cinema.exception.ResourceAlreadyExistsException;
import com.mobile.cinema.exception.ResourceNotFoundException;
import com.mobile.cinema.model.AccountModel;
import com.mobile.cinema.repository.CountryRepository;
import com.mobile.cinema.repository.AccountRepository;
import com.mobile.cinema.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final CountryRepository countryRepository;

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "The user with id =" + id + "does not exist."
        ));
    }

    @Override
    public Page<Account> getAccounts(PageDto pageDto) {
        return accountRepository.findAll(pageDto.getPageable());
    }

    @Override
    public Account addAccount(AccountModel accountModel) {
        Country country = countryRepository
                .findById(accountModel.getCountryId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The country with id=" + accountModel.getCountryId() + " does not exist."));

        if (accountRepository.existsByLoginAndPassword(accountModel.getLogin(), accountModel.getPassword())) {
            throw new ResourceAlreadyExistsException("The user with such login and password already exists.");
        }
        Account account = new Account(accountModel.getLogin(), accountModel.getPassword(),
                accountModel.getFirstName(), accountModel.getLastName(), country);
        accountRepository.save(account);
        return account;
    }

    @Override
    public Account updateAccount(Account account) {
        if (!accountRepository.existsById(account.getId())) {
            throw new ResourceNotFoundException("The account with id=" + account.getId() + " does not exist.");
        }
        if (!accountRepository.existsByLogin(account.getLogin())) {
            throw new ResourceNotFoundException("The account with login=" + account.getLogin() + " already exist.");
        }
        accountRepository.save(account);
        return account;

    }

    @Override
    public void deleteById(Long id) {
        if (!accountRepository.existsById(id))
            throw new ResourceNotFoundException("The account with id=" + id + " does not exist.");

        accountRepository.deleteById(id);
    }
}

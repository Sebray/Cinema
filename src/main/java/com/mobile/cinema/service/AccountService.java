package com.mobile.cinema.service;

import com.mobile.cinema.dto.PageDto;
import com.mobile.cinema.entity.Account;
import com.mobile.cinema.model.AccountModel;
import org.springframework.data.domain.Page;

public interface AccountService {
    Account getAccountById(Long id);

    Page<Account> getAccounts(PageDto pageDto);

    Account addAccount(AccountModel accountModel);

    Account updateAccount(Account account);

    void deleteById(Long id);
}

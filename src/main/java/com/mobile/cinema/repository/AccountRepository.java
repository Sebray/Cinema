package com.mobile.cinema.repository;

import com.mobile.cinema.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByLoginAndPassword(String login, String password);
    boolean existsByLogin(String login);
    Account findAccountByIdAndBalanceGreaterThanEqual(Long accountId, int minBalance);
}

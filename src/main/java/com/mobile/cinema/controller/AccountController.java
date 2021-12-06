package com.mobile.cinema.controller;

import com.mobile.cinema.dto.PageDto;
import com.mobile.cinema.entity.Account;
import com.mobile.cinema.model.AccountModel;
import com.mobile.cinema.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Account>> getAccounts(PageDto pageDto) {
        return new ResponseEntity<>(accountService.getAccounts(pageDto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Account> addAccount(@RequestBody AccountModel accountModel) {
        return new ResponseEntity<>(accountService.addAccount(accountModel), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        accountService.deleteById(id);
    }

}

package com.wm.workoutmonitoring.services;

import com.wm.workoutmonitoring.dtos.AccountDTO;
import com.wm.workoutmonitoring.exceptions.PasswordException;
import com.wm.workoutmonitoring.models.Account;
import com.wm.workoutmonitoring.models.Gender;
import com.wm.workoutmonitoring.repositories.AccountRepository;
import com.wm.workoutmonitoring.services.helpers.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordService passwordService;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findById(String id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.orElse(null);
    }

    public Account findByEmail(String email) {
        Optional<Account> account = accountRepository.findByEmail(email);
        return account.orElse(null);
    }

    public Account addAccount(AccountDTO accountDTO) {
        Account account = new Account();
        account.setName(accountDTO.getName());
        account.setEmail(accountDTO.getEmail());
        account.setDateOfBirth(accountDTO.getDateOfBirth());

        if (accountDTO.getGender().equals("M") || accountDTO.getGender().equals("Male") ||
                accountDTO.getGender().equals("m") || accountDTO.getGender().equals("male")) {
            account.setGender(Gender.MALE);
        } else if (accountDTO.getGender().equals("F") || accountDTO.getGender().equals("Female") ||
                accountDTO.getGender().equals("f") || accountDTO.getGender().equals("female")) {
            account.setGender(Gender.FEMALE);
        } else {
            account.setGender(Gender.UNDISCLOSED);
        }

        try {
            account.setPassword(passwordService.hashPassword(accountDTO.getPassword()));
        } catch (PasswordException e) {
            return null;
        }

        return account;
    }

    public int deleteAccount(String id){
        accountRepository.deleteById(id);
        return 200;
    }
}

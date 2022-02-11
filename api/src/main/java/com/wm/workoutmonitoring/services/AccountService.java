package com.wm.workoutmonitoring.services;

import com.wm.workoutmonitoring.dtos.AccountInputDTO;
import com.wm.workoutmonitoring.exceptions.PasswordException;
import com.wm.workoutmonitoring.models.Account;
import com.wm.workoutmonitoring.repositories.AccountRepository;
import com.wm.workoutmonitoring.services.helpers.GenderService;
import com.wm.workoutmonitoring.services.helpers.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private GenderService genderService;

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

    public Account addAccount(AccountInputDTO accountInputDTO) {
        Account account = new Account();
        account.setName(accountInputDTO.getName());
        account.setEmail(accountInputDTO.getEmail());
        account.setDateOfBirth(accountInputDTO.getDateOfBirth());
        account.setBodyWeight(accountInputDTO.getBodyWeight());
        account.setGender(genderService.determineGender(accountInputDTO.getGender()));
        account.setWorkoutList(new ArrayList<>());

        try {
            account.setPassword(passwordService.hashPassword(accountInputDTO.getPassword()));
        } catch (PasswordException e) {
            return null;
        }

        return accountRepository.save(account);
    }

    public Account update(Account account){
        return accountRepository.save(account);
    }

    public String deleteAccountById(String id){
        accountRepository.deleteById(id);
        return "Account successfully deleted.";
    }
}

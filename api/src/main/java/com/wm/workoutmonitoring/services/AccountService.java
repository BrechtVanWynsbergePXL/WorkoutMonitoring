package com.wm.workoutmonitoring.services;

import com.wm.workoutmonitoring.dtos.AccountDTO;
import com.wm.workoutmonitoring.exceptions.GenderException;
import com.wm.workoutmonitoring.exceptions.PasswordException;
import com.wm.workoutmonitoring.models.Account;
import com.wm.workoutmonitoring.models.Gender;
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

    public Account addAccount(AccountDTO accountDTO) {
        Account account = new Account();
        account.setName(accountDTO.getName());
        account.setEmail(accountDTO.getEmail());
        account.setDateOfBirth(accountDTO.getDateOfBirth());

        try{
            account.setGender(genderService.determineGender(accountDTO.getGender()));
        } catch (GenderException e){
            System.out.println(e.getMessage());
            account.setGender(Gender.UNDISCLOSED);
        }

        try {
            account.setPassword(passwordService.hashPassword(accountDTO.getPassword()));
        } catch (PasswordException e) {
            return null;
        }

        account.setWorkoutList(new ArrayList<>());

        return accountRepository.save(account);
    }

    public String deleteAccount(String id){
        accountRepository.deleteById(id);
        return "Account successfully deleted.";
    }
}

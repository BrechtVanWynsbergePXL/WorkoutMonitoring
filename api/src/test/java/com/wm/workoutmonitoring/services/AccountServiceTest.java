package com.wm.workoutmonitoring.services;

import com.wm.workoutmonitoring.models.Account;
import com.wm.workoutmonitoring.repositories.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    AccountService accountService;

    @Test
    public void findAllShouldReturnListOfAccounts() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account());

        when(accountRepository.findAll()).thenReturn(accountList);

        List<Account> returnedList = accountService.findAll();
        assertEquals(accountList, returnedList);
    }

    @Test
    public void findByIdShouldReturnAccount() {
        Account account = new Account();

        when(accountRepository.findById("testId")).thenReturn(java.util.Optional.of(account));

        Account returnedAccount = accountService.findById("testId");
        assertEquals(account, returnedAccount);
    }

    @Test
    public void findByEmailShouldReturnAccount() {
        Account account = new Account();

        when(accountRepository.findByEmail("testEmail")).thenReturn(java.util.Optional.of(account));

        Account returnedAccount = accountService.findByEmail("testEmail");
        assertEquals(account, returnedAccount);
    }

    @Test
    public void updateShouldReturnAccount() {
        Account account = new Account();

        when(accountRepository.save(account)).thenReturn(account);

        Account returnedAccount = accountService.update(account);
        assertEquals(account, returnedAccount);
    }

    @Test
    public void deleteAccountByIdShouldReturnString() {
        String response = accountService.deleteAccountById("testId");
        assertEquals("Account successfully deleted.", response);
    }
}

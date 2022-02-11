package com.wm.workoutmonitoring.dtos;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountInputDTOTest {
    private final AccountInputDTO accountInputDTO = new AccountInputDTO();

    @Test
    public void getAndSetNameTest() {
        String name = "testName";
        accountInputDTO.setName(name);
        assertEquals(name, accountInputDTO.getName());
    }

    @Test
    public void getAndSetPasswordTest() {
        String password = "testPassword";
        accountInputDTO.setPassword(password);
        assertEquals(password, accountInputDTO.getPassword());
    }

    @Test
    public void getAndSetEmailTest() {
        String email = "email@provider.com";
        accountInputDTO.setEmail(email);
        assertEquals(email, accountInputDTO.getEmail());
    }

    @Test
    public void getAndSetDateOfBirthTest() {
        Date date = new Date();
        accountInputDTO.setDateOfBirth(date);
        assertEquals(date, accountInputDTO.getDateOfBirth());
    }

    @Test
    public void getAndSetBodyWeightTest() {
        double bodyWeight = 10.0;
        accountInputDTO.setBodyWeight(bodyWeight);
        assertEquals(bodyWeight, accountInputDTO.getBodyWeight());
    }

    @Test
    public void getAndSetGenderTest() {
        String gender = "gender";
        accountInputDTO.setGender(gender);
        assertEquals(gender, accountInputDTO.getGender());
    }
}

package com.wm.workoutmonitoring.dtos;

import com.wm.workoutmonitoring.models.Gender;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountOutputDTOTest {
    private final AccountOutputDTO account = new AccountOutputDTO();

    @Test
    public void getAndSetIdTest() {
        String id = UUID.randomUUID().toString();
        account.setId(id);
        assertEquals(id, account.getId());
    }

    @Test
    public void getAndSetNameTest() {
        String name = "testName";
        account.setName(name);
        assertEquals(name, account.getName());
    }

    @Test
    public void getAndSetEmailTest() {
        String email = "email@provider.com";
        account.setEmail(email);
        assertEquals(email, account.getEmail());
    }

    @Test
    public void getAndSetDateOfBirthTest() {
        Date date = new Date();
        account.setDateOfBirth(date);
        assertEquals(date, account.getDateOfBirth());
    }

    @Test
    public void getAndSetBodyWeightTest() {
        double bodyWeight = 10.0;
        account.setBodyWeight(bodyWeight);
        assertEquals(bodyWeight, account.getBodyWeight());
    }

    @Test
    public void getAndSetGenderTest() {
        Gender gender = Gender.FEMALE;
        account.setGender(gender);
        assertEquals(gender, account.getGender());
    }
}

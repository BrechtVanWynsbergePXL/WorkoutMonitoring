package com.wm.workoutmonitoring.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    private final Account account = new Account();

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
    public void getAndSetPasswordTest() {
        String password = "testPassword";
        account.setPassword(password);
        assertEquals(password, account.getPassword());
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

    @Test
    public void getAndSetWorkoutListTest() {
        List<Workout> workoutList = new ArrayList<>();
        workoutList.add(new Workout());
        workoutList.add(new Workout());
        workoutList.add(new Workout());

        account.setWorkoutList(workoutList);
        assertEquals(workoutList, account.getWorkoutList());
        assertEquals(3, workoutList.size());
    }
}

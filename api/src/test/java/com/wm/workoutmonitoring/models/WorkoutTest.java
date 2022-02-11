package com.wm.workoutmonitoring.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkoutTest {
    private final Workout workout = new Workout();

    @Test
    public void getAndSetIdTest() {
        String id = UUID.randomUUID().toString();
        workout.setId(id);
        assertEquals(id, workout.getId());
    }

    @Test
    public void getAndSetAccountId() {
        String id = UUID.randomUUID().toString();
        workout.setAccountId(id);
        assertEquals(id, workout.getAccountId());
    }

    @Test
    public void getAndSetDateOfBirthTest() {
        Date date = new Date();
        workout.setDate(date);
        assertEquals(date, workout.getDate());
    }

    @Test
    public void getAndSetNameTest() {
        String name = "testName";
        workout.setName(name);
        assertEquals(name, workout.getName());
    }

    @Test
    public void getAndSetDescriptionTest() {
        String description = "test description";
        workout.setDescription(description);
        assertEquals(description, workout.getDescription());
    }

    @Test
    public void getAndSetExerciseList() {
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise());
        exerciseList.add(new Exercise());
        exerciseList.add(new Exercise());

        workout.setExerciseList(exerciseList);
        assertEquals(exerciseList, workout.getExerciseList());
        assertEquals(3, exerciseList.size());
    }
}

package com.wm.workoutmonitoring.models;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseTest {
    private final Exercise exercise = new Exercise();

    @Test
    public void getAndSetIdTest() {
        String id = UUID.randomUUID().toString();
        exercise.setId(id);
        assertEquals(id, exercise.getId());
    }

    @Test
    public void getAndSetWorkoutId() {
        String id = UUID.randomUUID().toString();
        exercise.setWorkoutId(id);
        assertEquals(id, exercise.getWorkoutId());
    }

    @Test
    public void getAndSetNameTest() {
        String name = "testName";
        exercise.setName(name);
        assertEquals(name, exercise.getName());
    }

    @Test
    public void getAndSetDescriptionTest() {
        String description = "test description";
        exercise.setDescription(description);
        assertEquals(description, exercise.getDescription());
    }

    @Test
    public void getAndSetSetsTest() {
        int sets = 3;
        exercise.setSets(sets);
        assertEquals(sets, exercise.getSets());
    }

    @Test
    public void getAndSetRepsTest() {
        int reps = 3;
        exercise.setReps(reps);
        assertEquals(reps, exercise.getReps());
    }

    @Test
    public void getAndSetWeightTest() {
        double weight = 12.3;
        exercise.setWeight(weight);
        assertEquals(weight, exercise.getWeight());
    }

    @Test
    public void getAndSetRpeTest() {
        double rpe = 8.5;
        exercise.setRpe(rpe);
        assertEquals(rpe, exercise.getRpe());
    }

    @Test
    public void getAndSetExerciseTypeTest() {
        ExerciseType exerciseType = ExerciseType.ACCESSORY;
        exercise.setBaseExercise(exerciseType);
        assertEquals(exerciseType, exercise.getBaseExercise());
    }
}

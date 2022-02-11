package com.wm.workoutmonitoring.dtos;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseInputDTOTest {
    private final ExerciseInputDTO exerciseInputDTO = new ExerciseInputDTO();

    @Test
    public void getAndSetIdTest() {
        String id = UUID.randomUUID().toString();
        exerciseInputDTO.setId(id);
        assertEquals(id, exerciseInputDTO.getId());
    }

    @Test
    public void getAndSetWorkoutId() {
        String id = UUID.randomUUID().toString();
        exerciseInputDTO.setWorkoutId(id);
        assertEquals(id, exerciseInputDTO.getWorkoutId());
    }

    @Test
    public void getAndSetNameTest() {
        String name = "testName";
        exerciseInputDTO.setName(name);
        assertEquals(name, exerciseInputDTO.getName());
    }

    @Test
    public void getAndSetDescriptionTest() {
        String description = "test description";
        exerciseInputDTO.setDescription(description);
        assertEquals(description, exerciseInputDTO.getDescription());
    }

    @Test
    public void getAndSetSetsTest() {
        int sets = 3;
        exerciseInputDTO.setSets(sets);
        assertEquals(sets, exerciseInputDTO.getSets());
    }

    @Test
    public void getAndSetRepsTest() {
        int reps = 3;
        exerciseInputDTO.setReps(reps);
        assertEquals(reps, exerciseInputDTO.getReps());
    }

    @Test
    public void getAndSetWeightTest() {
        double weight = 12.3;
        exerciseInputDTO.setWeight(weight);
        assertEquals(weight, exerciseInputDTO.getWeight());
    }

    @Test
    public void getAndSetRpeTest() {
        double rpe = 8.5;
        exerciseInputDTO.setRpe(rpe);
        assertEquals(rpe, exerciseInputDTO.getRpe());
    }

    @Test
    public void getAndSetExerciseTypeTest() {
        String exerciseType = "squat";
        exerciseInputDTO.setExerciseType(exerciseType);
        assertEquals(exerciseType, exerciseInputDTO.getExerciseType());
    }
}

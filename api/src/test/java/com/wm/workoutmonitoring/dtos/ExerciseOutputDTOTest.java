package com.wm.workoutmonitoring.dtos;

import com.wm.workoutmonitoring.models.ExerciseType;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseOutputDTOTest {
    private final ExerciseOutputDTO exerciseOutputDTO = new ExerciseOutputDTO();

    @Test
    public void getAndSetIdTest() {
        String id = UUID.randomUUID().toString();
        exerciseOutputDTO.setId(id);
        assertEquals(id, exerciseOutputDTO.getId());
    }

    @Test
    public void getAndSetWorkoutId() {
        String id = UUID.randomUUID().toString();
        exerciseOutputDTO.setWorkoutId(id);
        assertEquals(id, exerciseOutputDTO.getWorkoutId());
    }

    @Test
    public void getAndSetNameTest() {
        String name = "testName";
        exerciseOutputDTO.setName(name);
        assertEquals(name, exerciseOutputDTO.getName());
    }

    @Test
    public void getAndSetDescriptionTest() {
        String description = "test description";
        exerciseOutputDTO.setDescription(description);
        assertEquals(description, exerciseOutputDTO.getDescription());
    }

    @Test
    public void getAndSetSetsTest() {
        int sets = 3;
        exerciseOutputDTO.setSets(sets);
        assertEquals(sets, exerciseOutputDTO.getSets());
    }

    @Test
    public void getAndSetRepsTest() {
        int reps = 3;
        exerciseOutputDTO.setReps(reps);
        assertEquals(reps, exerciseOutputDTO.getReps());
    }

    @Test
    public void getAndSetWeightTest() {
        double weight = 12.3;
        exerciseOutputDTO.setWeight(weight);
        assertEquals(weight, exerciseOutputDTO.getWeight());
    }

    @Test
    public void getAndSetRpeTest() {
        double rpe = 8.5;
        exerciseOutputDTO.setRpe(rpe);
        assertEquals(rpe, exerciseOutputDTO.getRpe());
    }

    @Test
    public void getAndSetExerciseTypeTest() {
        ExerciseType exerciseType = ExerciseType.ACCESSORY;
        exerciseOutputDTO.setExerciseType(exerciseType);
        assertEquals(exerciseType, exerciseOutputDTO.getExerciseType());
    }
}

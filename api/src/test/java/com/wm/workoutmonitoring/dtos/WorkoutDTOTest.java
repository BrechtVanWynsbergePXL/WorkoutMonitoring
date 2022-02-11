package com.wm.workoutmonitoring.dtos;

import com.wm.workoutmonitoring.models.Exercise;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkoutDTOTest {
    private final WorkoutDTO workoutDTO = new WorkoutDTO();

    @Test
    public void getAndSetIdTest() {
        String id = UUID.randomUUID().toString();
        workoutDTO.setId(id);
        assertEquals(id, workoutDTO.getId());
    }

    @Test
    public void getAndSetAccountId() {
        String id = UUID.randomUUID().toString();
        workoutDTO.setAccountId(id);
        assertEquals(id, workoutDTO.getAccountId());
    }

    @Test
    public void getAndSetDateOfBirthTest() {
        Date date = new Date();
        workoutDTO.setDate(date);
        assertEquals(date, workoutDTO.getDate());
    }

    @Test
    public void getAndSetNameTest() {
        String name = "testName";
        workoutDTO.setName(name);
        assertEquals(name, workoutDTO.getName());
    }

    @Test
    public void getAndSetDescriptionTest() {
        String description = "test description";
        workoutDTO.setDescription(description);
        assertEquals(description, workoutDTO.getDescription());
    }

    @Test
    public void getAndSetExerciseList() {
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise());
        exerciseList.add(new Exercise());
        exerciseList.add(new Exercise());

        workoutDTO.setExerciseList(exerciseList);
        assertEquals(exerciseList, workoutDTO.getExerciseList());
        assertEquals(3, exerciseList.size());
    }
}

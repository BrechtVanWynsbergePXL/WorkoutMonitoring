package com.wm.workoutmonitoring.services;

import com.wm.workoutmonitoring.dtos.ExerciseInputDTO;
import com.wm.workoutmonitoring.models.Exercise;
import com.wm.workoutmonitoring.repositories.ExerciseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExerciseServiceTest {
    @Mock
    ExerciseRepository exerciseRepository;

    @InjectMocks
    ExerciseService exerciseService;

    @Test
    public void findAllShouldReturnListOfExercises() {
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise());

        when(exerciseRepository.findAll()).thenReturn(exerciseList);

        List<Exercise> returnedList = exerciseService.findAll();

        assertEquals(exerciseList, returnedList);
    }

    @Test
    public void findAllByIdShouldReturnListOfExercises() {
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise());

        when(exerciseRepository.findByWorkoutId("testId")).thenReturn(java.util.Optional.of(exerciseList));

        List<Exercise> returnedList = exerciseService.findAllByWorkoutId("testId");

        assertEquals(exerciseList, returnedList);
    }

    @Test
    public void updateExerciseShouldReturnExercise() {
        Exercise exercise = new Exercise();
        exercise.setName("test exercise");

        when(exerciseRepository.save(any(Exercise.class))).thenReturn(exercise);

        Exercise created = exerciseService.updateExercise(exercise);

        assertEquals(exercise.getName(), created.getName());
    }

    @Test
    public void deleteExerciseByIdShouldReturnString() {
        String response = exerciseService.deleteExerciseById("testId");
        assertEquals("Workout successfully deleted.", response);
    }

    @Test
    public void mapExerciseDTOToExerciseShouldReturnExercise() {
        ExerciseInputDTO exerciseInputDTO = new ExerciseInputDTO();
        exerciseInputDTO.setWorkoutId("testId");
        exerciseInputDTO.setName("testName");
        exerciseInputDTO.setDescription("testDescription");
        exerciseInputDTO.setSets(3);
        exerciseInputDTO.setReps(3);
        exerciseInputDTO.setWeight(100);
        exerciseInputDTO.setRpe(10);

        Exercise mappedExercise = exerciseService.mapExerciseDTOtoExercise(exerciseInputDTO);

        assertEquals(exerciseInputDTO.getWorkoutId(), mappedExercise.getWorkoutId());
        assertEquals(exerciseInputDTO.getName(), mappedExercise.getName());
        assertEquals(exerciseInputDTO.getDescription(), mappedExercise.getDescription());
        assertEquals(exerciseInputDTO.getSets(), mappedExercise.getSets());
        assertEquals(exerciseInputDTO.getReps(), mappedExercise.getReps());
        assertEquals(exerciseInputDTO.getWeight(), mappedExercise.getWeight(), 0.01);
        assertEquals(exerciseInputDTO.getRpe(), mappedExercise.getRpe(), 0.01);
    }
}

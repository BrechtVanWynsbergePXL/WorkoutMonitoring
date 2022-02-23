package com.wm.workoutmonitoring.services;

import com.wm.workoutmonitoring.controllers.WorkoutController;
import com.wm.workoutmonitoring.models.Workout;
import com.wm.workoutmonitoring.repositories.WorkoutRepository;
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
public class WorkoutServiceTest {
    @Mock
    WorkoutRepository workoutRepository;

    @InjectMocks
    WorkoutService workoutService;

    @Test
    public void findAllShouldReturnWorkoutList() {
        List<Workout> workoutList = new ArrayList<>();
        workoutList.add(new Workout());

        when(workoutRepository.findAll()).thenReturn(workoutList);

        List<Workout> returnedList = workoutService.findAll();
        assertEquals(workoutList, returnedList);
    }

    @Test
    public void findAllByAccountIdShouldReturnWorkoutList() {
        List<Workout> workoutList = new ArrayList<>();
        workoutList.add(new Workout());

        when(workoutRepository.findAllByAccountId("testId")).thenReturn(java.util.Optional.of(workoutList));

        List<Workout> returnedList = workoutService.findAllByAccountId("testId");
        assertEquals(workoutList, returnedList);
    }

    @Test
    public void findOneByIdShouldReturnWorkout() {
        Workout workout = new Workout();

        when(workoutRepository.findById("testId")).thenReturn(java.util.Optional.of(workout));

        Workout returnedWorkout = workoutService.findOneById("testId");
        assertEquals(workout, returnedWorkout);
    }

    @Test
    public void updateShouldReturnWorkout() {
        Workout workout = new Workout();
        workout.setName("test workout");

        when(workoutRepository.save(any(Workout.class))).thenReturn(workout);

        Workout created = workoutService.update(workout);
        assertEquals(workout, created);
    }
}

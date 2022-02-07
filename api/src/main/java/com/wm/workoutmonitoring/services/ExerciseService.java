package com.wm.workoutmonitoring.services;

import com.wm.workoutmonitoring.dtos.ExerciseDTO;
import com.wm.workoutmonitoring.exceptions.ExerciseNotFoundException;
import com.wm.workoutmonitoring.models.Account;
import com.wm.workoutmonitoring.models.BaseExercise;
import com.wm.workoutmonitoring.models.Exercise;
import com.wm.workoutmonitoring.models.Workout;
import com.wm.workoutmonitoring.repositories.ExerciseRepository;
import com.wm.workoutmonitoring.services.helpers.ExerciseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private ExerciseTypeService exerciseTypeService;

    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    public List<Exercise> findAllByWorkoutId(String id) {
        Optional<List<Exercise>> exercises = exerciseRepository.findByWorkoutId(id);
        return exercises.orElse(null);
    }

    public List<Exercise> findAllByAccountId(String id) {
        List<Exercise> exercises = new ArrayList<>();
        Account account = accountService.findById(id);
        for (Workout workout : account.getWorkoutList()) {
            exercises.addAll(workout.getExerciseList());
        }
        return exercises;
    }

    public Exercise addExercise(ExerciseDTO exerciseDTO) {
        Workout workout = workoutService.findOneById(exerciseDTO.getWorkoutId());
        Account account = accountService.findById(workout.getAccountId());

        Exercise exercise = this.mapExerciseDTOtoExercise(exerciseDTO);
        exercise.setBaseExercise(exerciseTypeService.determineBaseExercise(exerciseDTO.getExerciseType()));
        exerciseRepository.save(exercise);

        List<Exercise> exercises = workout.getExerciseList();
        exercises.add(exercise);
        workout.setExerciseList(exercises);
        workoutService.update(workout);

        List<Workout> workouts = account.getWorkoutList();
        workouts.add(workout);
        account.setWorkoutList(workouts);
        accountService.update(account);

        return exercise;
    }

    public Exercise updateExercise(ExerciseDTO exerciseDTO) throws ExerciseNotFoundException {
        Optional<Exercise> exerciseToUpdate = exerciseRepository.findById(exerciseDTO.getId());

        if(exerciseToUpdate.isPresent()){
            Exercise exercise = this.mapExerciseDTOtoExercise(exerciseDTO);
            exercise.setBaseExercise(exerciseTypeService.determineBaseExercise(exerciseDTO.getExerciseType()));

            return exerciseRepository.save(exercise);
        }
        throw new ExerciseNotFoundException("Exercise could not be found.");
    }

    private Exercise mapExerciseDTOtoExercise(BaseExercise exercise) {
        exercise.setWorkoutId(exercise.getWorkoutId());
        exercise.setName(exercise.getName());
        exercise.setDescription(exercise.getDescription());
        exercise.setSets(exercise.getSets());
        exercise.setReps(exercise.getReps());
        exercise.setRpe(exercise.getRpe());

        return (Exercise) exercise;
    }
}

package com.wm.workoutmonitoring.services;

import com.wm.workoutmonitoring.dtos.ExerciseInputDTO;
import com.wm.workoutmonitoring.exceptions.ExerciseNotFoundException;
import com.wm.workoutmonitoring.models.Account;
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

    public Exercise addExercise(ExerciseInputDTO exerciseInputDTO) {
        List<Workout> workouts;

        Workout workout = workoutService.findOneById(exerciseInputDTO.getWorkoutId());

        Exercise exercise = this.mapExerciseDTOtoExercise(exerciseInputDTO);
        exercise.setBaseExercise(exerciseTypeService.determineBaseExercise(exerciseInputDTO.getExerciseType()));
        exerciseRepository.save(exercise);

        List<Exercise> exercises = workout.getExerciseList();
        exercises.add(exercise);
        workout.setExerciseList(exercises);
        workoutService.update(workout);

        return exercise;
    }

    public Exercise updateExercise(ExerciseInputDTO exerciseInputDTO) throws ExerciseNotFoundException {
        Optional<Exercise> exerciseToUpdate = exerciseRepository.findById(exerciseInputDTO.getId());

        if(exerciseToUpdate.isPresent()){
            Exercise exercise = this.mapExerciseDTOtoExercise(exerciseInputDTO);
            exercise.setBaseExercise(exerciseTypeService.determineBaseExercise(exerciseInputDTO.getExerciseType()));

            return exerciseRepository.save(exercise);
        }
        throw new ExerciseNotFoundException("Exercise could not be found.");
    }

    public String deleteExerciseById(String id) {
        exerciseRepository.deleteById(id);
        return "Workout successfully deleted.";
    }

    private Exercise mapExerciseDTOtoExercise(ExerciseInputDTO exerciseInputDTO) {
        Exercise exercise = new Exercise();

        exercise.setWorkoutId(exerciseInputDTO.getWorkoutId());
        exercise.setName(exerciseInputDTO.getName());
        exercise.setDescription(exerciseInputDTO.getDescription());
        exercise.setSets(exerciseInputDTO.getSets());
        exercise.setReps(exerciseInputDTO.getReps());
        exercise.setWeight(exerciseInputDTO.getWeight());
        exercise.setRpe(exerciseInputDTO.getRpe());

        return exercise;
    }
}

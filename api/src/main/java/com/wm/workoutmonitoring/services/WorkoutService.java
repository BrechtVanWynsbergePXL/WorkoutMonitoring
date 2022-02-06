package com.wm.workoutmonitoring.services;

import com.wm.workoutmonitoring.dtos.WorkoutDTO;
import com.wm.workoutmonitoring.models.Account;
import com.wm.workoutmonitoring.models.Workout;
import com.wm.workoutmonitoring.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class WorkoutService {
    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workout> findAll() {
        return workoutRepository.findAll();
    }

    public List<Workout> findAllByAccountId(String id) {
        Optional<List<Workout>> workoutList = workoutRepository.findAllByAccountId(id);
        return workoutList.orElse(null);
    }

    public Workout findOneById(String id) {
        Optional<Workout> workout = workoutRepository.findById(id);
        return workout.orElse(null);
    }

    public Workout addWorkout(WorkoutDTO workoutDTO) {
        Workout workout = new Workout();
        workout.setAccountId(workoutDTO.getAccountId());
        workout.setName(workoutDTO.getName());
        workout.setDescription(workoutDTO.getDescription());
        workout.setExerciseList(new ArrayList<>());

        return workoutRepository.save(workout);
    }

    public String deleteById(String id) {
        workoutRepository.deleteById(id);
        return "Workout successfully deleted.";
    }
}

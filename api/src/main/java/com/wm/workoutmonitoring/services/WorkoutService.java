package com.wm.workoutmonitoring.services;

import com.wm.workoutmonitoring.dtos.WorkoutDTO;
import com.wm.workoutmonitoring.exceptions.WorkoutNotFoundException;
import com.wm.workoutmonitoring.models.Account;
import com.wm.workoutmonitoring.models.Workout;
import com.wm.workoutmonitoring.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Service
public class WorkoutService {
    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private AccountService accountService;

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
        workout.setDate(workoutDTO.getDate());
        workout.setName(workoutDTO.getName());
        workout.setDescription(workoutDTO.getDescription());
        workout.setExerciseList(new ArrayList<>());
        workoutRepository.save(workout);

        Account account = accountService.findById(workoutDTO.getAccountId());
        account.getWorkoutList().add(workout);

        accountService.update(account);

        return workout;
    }

    public Workout update(Workout workout) {
        return workoutRepository.save(workout);
    }

    public Workout update(WorkoutDTO workoutDTO) throws WorkoutNotFoundException {
        Optional<Workout> workoutToUpdate = workoutRepository.findById(workoutDTO.getId());

        if (workoutToUpdate.isPresent()) {
            Workout workout = this.mapAndCombineWorkoutDTOtoWorkout(workoutToUpdate.get(), workoutDTO);

            return workoutRepository.save(workout);
        }
        throw new WorkoutNotFoundException("Workout could not be found.");
    }

    public String deleteWorkoutById(String id) {
        workoutRepository.deleteById(id);
        return "Workout successfully deleted.";
    }

    private Workout mapAndCombineWorkoutDTOtoWorkout(Workout workout, WorkoutDTO workoutDTO) {
        workout.setDate(workoutDTO.getDate());
        workout.setName(workoutDTO.getName());
        workout.setDescription(workoutDTO.getDescription());
        workout.setExerciseList(Stream.of(workout.getExerciseList(), workoutDTO.getExerciseList()).flatMap(Collection::stream).collect(Collectors.toList()));

        return workout;
    }
}

package com.wm.workoutmonitoring.repositories;

import com.wm.workoutmonitoring.models.Workout;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface WorkoutRepository extends CrudRepository<Workout, String> {
    List<Workout> findAll();
    Optional<List<Workout>> findAllByAccountId(String id);

    @Override
    void deleteById(String id);
}

package com.wm.workoutmonitoring.repositories;

import com.wm.workoutmonitoring.models.Workout;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkoutRepository extends CrudRepository<Workout, String> {
    List<Workout> findAll();

    @Override
    void deleteById(String id);
}

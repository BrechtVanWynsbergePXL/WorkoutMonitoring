package com.wm.workoutmonitoring.repositories;

import com.wm.workoutmonitoring.models.Exercise;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExerciseRepository extends CrudRepository<Exercise, String> {
    List<Exercise> findAll();

    @Override
    void deleteById(String id);
}

package com.wm.workoutmonitoring.repositories;

import com.wm.workoutmonitoring.models.Exercise;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends CrudRepository<Exercise, String> {
    List<Exercise> findAll();
    Optional<List<Exercise>> findByWorkoutId(String id);

    @Override
    void deleteById(String id);
}

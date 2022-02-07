package com.wm.workoutmonitoring.services.helpers;

import com.wm.workoutmonitoring.models.ExerciseType;
import org.springframework.stereotype.Service;

@Service
public class ExerciseTypeService {
    public ExerciseType determineBaseExercise(String exercise) {
        switch (exercise) {
            case "Bench":
            case "bench":
            case "B":
            case "b":
                return ExerciseType.BENCH;
            case "Squat":
            case "squat":
            case "s":
            case "S":
                return ExerciseType.SQUAT;
            case "Deadlift":
            case "deadlift":
            case "D":
            case "d":
                return ExerciseType.DEADLIFT;
            default:
                return ExerciseType.UNDEFINED;
        }
    }
}

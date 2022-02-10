package com.wm.workoutmonitoring.services.helpers;

import com.wm.workoutmonitoring.models.ExerciseType;
import org.springframework.stereotype.Service;

@Service
public class ExerciseTypeService {
    public ExerciseType determineBaseExercise(String exerciseName) {
        if(exerciseName.toLowerCase().contains("press") || exerciseName.toLowerCase().contains("bench")
                || exerciseName.toLowerCase().contains("push ups") || exerciseName.toLowerCase().contains("pushups")
                || exerciseName.toLowerCase().contains("pec") || exerciseName.toLowerCase().contains("chest")
                || exerciseName.toLowerCase().contains("bp")) {
            if(exerciseName.toLowerCase().contains("jm press")){
                return ExerciseType.ACCESSORY;
            }
            return ExerciseType.PRESS;
        }
        if(exerciseName.toLowerCase().contains("squat") || exerciseName.toLowerCase().contains("leg extention")){
            return ExerciseType.SQUAT;
        }
        if(exerciseName.toLowerCase().contains("deadlift") || exerciseName.toLowerCase().contains("rdl")
                || exerciseName.toLowerCase().contains("sumo") || exerciseName.toLowerCase().contains("dl")
                || exerciseName.toLowerCase().contains("back extention")){
            return ExerciseType.DEADLIFT;
        }
        return ExerciseType.ACCESSORY;
    }
}

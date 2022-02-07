package com.wm.workoutmonitoring.dtos;

import com.wm.workoutmonitoring.models.BaseExercise;

public class ExerciseDTO extends BaseExercise {
    private String id;
    private String exerciseType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setBaseExercise(String exerciseType) {
        this.exerciseType = exerciseType;
    }
}

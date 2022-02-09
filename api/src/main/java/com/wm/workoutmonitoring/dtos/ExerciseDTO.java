package com.wm.workoutmonitoring.dtos;

public class ExerciseDTO {
    private String id;
    private String workoutId;
    private String name;
    private String description;
    private int sets;
    private int reps;
    private double weight;
    private double rpe;
    private String exerciseType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(String workoutId) {
        this.workoutId = workoutId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getRpe() {
        return rpe;
    }

    public void setRpe(double rpe) {
        this.rpe = rpe;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setBaseExercise(String exerciseType) {
        this.exerciseType = exerciseType;
    }
}

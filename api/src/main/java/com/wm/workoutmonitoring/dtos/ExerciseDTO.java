package com.wm.workoutmonitoring.dtos;

public class ExerciseDTO {
    private String workoutId;
    private String name;
    private String description;
    private int sets;
    private int reps;
    private double weight;
    private double rpe;
    private String baseExercise;

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

    public String getBaseExercise() {
        return baseExercise;
    }

    public void setBaseExercise(String baseExercise) {
        this.baseExercise = baseExercise;
    }
}

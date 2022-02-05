package com.wm.workoutmonitoring.models;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.UUID;

@Entity
@Embeddable
public class Exercise {
    @Id
    private String id;
    private String name;
    private String description;
    private int sets;
    private int reps;
    private double weight;
    private double rpe;
    private BaseExercise baseExercise;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public BaseExercise getBaseExercise() {
        return baseExercise;
    }

    public void setBaseExercise(BaseExercise baseExercise) {
        this.baseExercise = baseExercise;
    }

    @PrePersist
    public void prePersist() {
        if(getId() == null){
            setId(UUID.randomUUID().toString());
        }
    }
}

package com.wm.workoutmonitoring.models;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.UUID;

@Entity
@Embeddable
public class Exercise extends BaseExercise{
    @Id
    private String id;
    private ExerciseType exerciseType;

    public Exercise() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ExerciseType getBaseExercise() {
        return exerciseType;
    }

    public void setBaseExercise(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }

    @PrePersist
    public void prePersist() {
        if (getId() == null) {
            setId(UUID.randomUUID().toString());
        }
    }
}

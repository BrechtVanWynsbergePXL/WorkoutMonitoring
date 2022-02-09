package com.wm.workoutmonitoring.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Embeddable
public class Workout {
    @Id
    private String id;
    private String accountId;
    private Date date;
    private String name;
    private String description;
    @OneToMany
    private List<Exercise> exerciseList;

    public Workout() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    @PrePersist
    public void prePersist() {
        if (getId() == null) {
            setId(UUID.randomUUID().toString());
        }
    }
}

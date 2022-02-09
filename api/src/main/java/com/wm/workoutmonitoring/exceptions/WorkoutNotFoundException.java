package com.wm.workoutmonitoring.exceptions;

public class WorkoutNotFoundException extends Exception{
    public WorkoutNotFoundException(String exceptionMessage) {
        super(exceptionMessage);
    }
}

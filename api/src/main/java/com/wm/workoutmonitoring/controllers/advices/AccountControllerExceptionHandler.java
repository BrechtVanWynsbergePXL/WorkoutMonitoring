package com.wm.workoutmonitoring.controllers.advices;

import com.wm.workoutmonitoring.exceptions.ExerciseNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccountControllerExceptionHandler {
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> handleRecordNotFound(EmptyResultDataAccessException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExerciseNotFoundException.class)
    public ResponseEntity<String> handleExerciseNotFound(ExerciseNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}

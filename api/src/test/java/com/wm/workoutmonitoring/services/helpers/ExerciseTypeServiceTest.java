package com.wm.workoutmonitoring.services.helpers;

import com.wm.workoutmonitoring.models.ExerciseType;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ExerciseTypeServiceTest {
    @Autowired
    private ExerciseTypeService exerciseTypeService;

    @ParameterizedTest
    @ValueSource(strings = {"jm press", "random", "exercise", "accessory"})
    public void serviceShouldReturnAccessoryOnRandomString(String input) {
        ExerciseType type = exerciseTypeService.determineBaseExercise(input);
        assertEquals(ExerciseType.ACCESSORY, type);
    }

    @ParameterizedTest
    @ValueSource(strings = {"press", "push press", "benchpress", "bench", "push ups", "pec fly", "chest fly", "bp"})
    public void serviceShouldReturnPressOnStringContainingRightInput(String input) {
        ExerciseType type = exerciseTypeService.determineBaseExercise(input);
        assertEquals(ExerciseType.PRESS, type);
    }

    @ParameterizedTest
    @ValueSource(strings = {"squat", "split squat", "leg extention", "bulgarian squat"})
    public void serviceShouldReturnSquatOnStringContainingRightInput(String input) {
        ExerciseType type = exerciseTypeService.determineBaseExercise(input);
        assertEquals(ExerciseType.SQUAT, type);
    }

    @ParameterizedTest
    @ValueSource(strings = {"deadlift", "rdl", "romanian deadlift", "sumo deadlift", "dl", "back extention", "stiff leg deadlift"})
    public void serviceShouldReturnDeadliftOnStringContainingRightInput(String input) {
        ExerciseType type = exerciseTypeService.determineBaseExercise(input);
        assertEquals(ExerciseType.DEADLIFT, type);
    }
}

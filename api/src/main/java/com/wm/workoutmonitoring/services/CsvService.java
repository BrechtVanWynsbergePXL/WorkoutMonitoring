package com.wm.workoutmonitoring.services;

import com.wm.workoutmonitoring.models.Account;
import com.wm.workoutmonitoring.models.Exercise;
import com.wm.workoutmonitoring.models.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CsvService {
    @Autowired
    private AccountService accountService;

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private ExerciseService exerciseService;

    public List<Workout> processCsv(String id, MultipartFile multipartFile) throws IOException {
        Account account = accountService.findById(id);

        List<Workout> workoutList = account.getWorkoutList();

        var ref = new Object() {
            Workout workout = null;
        };


        new BufferedReader(new InputStreamReader(multipartFile.getInputStream(), StandardCharsets.UTF_8))
                .lines()
                .forEach(line -> {
                    String[] allProperties = line.split(",");
                    if(allProperties[0].equals("\uFEFFWO") ||allProperties[0].equals("WO")){
                        if(ref.workout != null){
                            workoutService.update(ref.workout);
                            workoutList.add(ref.workout);
                        }
                        try {
                            ref.workout = generateWorkoutFromStringArray(id, allProperties);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Exercise exercise = generateExerciseFromStringArray(ref.workout.getId(), allProperties);
                        exerciseService.updateExercise(exercise);
                        List<Exercise> exerciseList = ref.workout.getExerciseList();
                        exerciseList.add(exercise);

                        ref.workout.setExerciseList(exerciseList);
                    }
                });
        workoutService.update(ref.workout);
        workoutList.add(ref.workout);

        account.setWorkoutList(workoutList);

        accountService.update(account);
        return workoutList;
    }

    private Workout generateWorkoutFromStringArray(String id, String[] properties) throws ParseException {
        Workout workout = new Workout();
        workout.setId(UUID.randomUUID().toString());
        workout.setAccountId(id);
        workout.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(properties[1]));
        workout.setName(properties[2]);
        if(properties.length > 3 && !properties[3].equals("")){
            workout.setDescription(properties[3]);
        } else {
            workout.setDescription("");
        }
        workout.setExerciseList(new ArrayList<>());

        return workout;
    }

    private Exercise generateExerciseFromStringArray(String id, String[] properties) {
        Exercise exercise = new Exercise();
        exercise.setWorkoutId(id);
        exercise.setName(properties[1]);
        exercise.setSets(Integer.parseInt(properties[2]));
        if(properties.length > 3 && !properties[3].equals("")){
            exercise.setReps(Integer.parseInt(properties[3]));
        } else {
            exercise.setReps(0);
        }

        if(properties.length > 4 && !properties[4].equals("")){
            exercise.setRpe(Double.parseDouble(properties[4]));
        } else {
            exercise.setRpe(0);
        }

        if(properties.length > 5 && !properties[5].equals("")){
            exercise.setWeight(Double.parseDouble(properties[5]));
        }else {
            exercise.setWeight(0);
        }

        if(properties.length == 7){
            exercise.setDescription(properties[6]);
        }

        return exercise;
    }
}

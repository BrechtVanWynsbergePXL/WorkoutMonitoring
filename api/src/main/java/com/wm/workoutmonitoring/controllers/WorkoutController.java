package com.wm.workoutmonitoring.controllers;

import com.wm.workoutmonitoring.dtos.WorkoutDTO;
import com.wm.workoutmonitoring.services.WorkoutService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workout")
@CrossOrigin(origins = "*")
public class WorkoutController {
    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/findAll")
    public ResponseEntity<List<WorkoutDTO>> getAll() {
        return new ResponseEntity<>(workoutService.findAll()
                .stream().map(workout -> modelMapper.map(workout, WorkoutDTO.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/findByAccountId/{id}")
    public ResponseEntity<List<WorkoutDTO>> getAllByAccountId(@PathVariable("id") String id) {
        return new ResponseEntity<>(workoutService.findAllByAccountId(id)
                .stream().map(workout -> modelMapper.map(workout, WorkoutDTO.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/findOneById/{id}")
    public ResponseEntity<WorkoutDTO> getOneById(@PathVariable("id") String id) {
        return new ResponseEntity<>(modelMapper.map(workoutService.findOneById(id), WorkoutDTO.class), HttpStatus.OK);
    }

    @PostMapping("/addWorkout")
    public ResponseEntity<WorkoutDTO> postWorkout(@RequestBody WorkoutDTO workoutDTO) {
        return new ResponseEntity<>(modelMapper.map(workoutService.addWorkout(workoutDTO), WorkoutDTO.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteOneById/{id}")
    public ResponseEntity<String> deleteOneById(@PathVariable("id") String id) {
        return new ResponseEntity<>(workoutService.deleteWorkoutById(id), HttpStatus.OK);
    }
}

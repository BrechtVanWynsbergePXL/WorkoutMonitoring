package com.wm.workoutmonitoring.controllers;

import com.wm.workoutmonitoring.dtos.ExerciseDTO;
import com.wm.workoutmonitoring.exceptions.ExerciseNotFoundException;
import com.wm.workoutmonitoring.services.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/exercise")
@CrossOrigin(origins = "*")
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/findAll")
    public ResponseEntity<List<ExerciseDTO>> getAll() {
        return new ResponseEntity<>(exerciseService.findAll()
                .stream().map(exercise -> modelMapper.map(exercise, ExerciseDTO.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/findAllByWorkoutId/{id}")
    public ResponseEntity<List<ExerciseDTO>> getAllByWorkoutId(@PathVariable("id") String id) {
        return new ResponseEntity<>(exerciseService.findAllByWorkoutId(id)
                .stream().map(exercise -> modelMapper.map(exercise, ExerciseDTO.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/findAllByAccountId/{id}")
    public ResponseEntity<List<ExerciseDTO>> getAllByAccountId(@PathVariable("id") String id) {
        return new ResponseEntity<>(exerciseService.findAllByAccountId(id)
                .stream().map(exercise -> modelMapper.map(exercise, ExerciseDTO.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping("/addExercise")
    public ResponseEntity<ExerciseDTO> postExercise(@RequestBody ExerciseDTO exerciseDTO) {
        return new ResponseEntity<>(modelMapper.map(exerciseService.addExercise(exerciseDTO), ExerciseDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/updateExercise")
    public ResponseEntity<ExerciseDTO> putExercise(@RequestBody ExerciseDTO exerciseDTO) throws ExerciseNotFoundException {
        return new ResponseEntity<>(modelMapper.map(exerciseService.updateExercise(exerciseDTO), ExerciseDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/deleteOneById/{id}")
    public ResponseEntity<String> deleteOneById(@PathVariable("id") String id) {
        return new ResponseEntity<>(exerciseService.deleteExerciseById(id), HttpStatus.OK);
    }
}

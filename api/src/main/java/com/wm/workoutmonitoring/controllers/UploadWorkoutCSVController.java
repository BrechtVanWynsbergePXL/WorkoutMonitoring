package com.wm.workoutmonitoring.controllers;

import com.wm.workoutmonitoring.dtos.WorkoutDTO;
import com.wm.workoutmonitoring.services.CsvService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/csv")
@CrossOrigin(origins = "*")
public class UploadWorkoutCSVController {
    @Autowired
    private CsvService csvService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/upload/{id}")
    public ResponseEntity<List<WorkoutDTO>> processCsv(@RequestParam(value = "file") MultipartFile file, @PathVariable("id") String id) throws IOException {
        return new ResponseEntity<>(csvService.processCsv(id, file)
                .stream().map(workout -> modelMapper.map(workout, WorkoutDTO.class))
                .collect(Collectors.toList()), HttpStatus.CREATED);
    }
}

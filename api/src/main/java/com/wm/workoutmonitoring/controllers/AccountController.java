package com.wm.workoutmonitoring.controllers;

import com.wm.workoutmonitoring.dtos.AccountInputDTO;
import com.wm.workoutmonitoring.dtos.AccountOutputDTO;
import com.wm.workoutmonitoring.services.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "*")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/findAll")
    public ResponseEntity<List<AccountOutputDTO>> getAll() {
        return new ResponseEntity<>(accountService.findAll()
                .stream().map(account -> modelMapper.map(account, AccountOutputDTO.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<AccountOutputDTO> getOneById(@PathVariable("id") String id) {
        return new ResponseEntity<>(modelMapper.map(accountService.findById(id), AccountOutputDTO.class), HttpStatus.OK);
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<AccountOutputDTO> getOneByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(modelMapper.map(accountService.findByEmail(email), AccountOutputDTO.class), HttpStatus.OK);
    }

    @PostMapping("/addAccount")
    public ResponseEntity<AccountOutputDTO> postAccount(@RequestBody AccountInputDTO accountInputDTO) {
        return new ResponseEntity<>(modelMapper.map(accountService.addAccount(accountInputDTO), AccountOutputDTO.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteOneById/{id}")
    public ResponseEntity<String> deleteOneById(@PathVariable("id") String id) {
        return new ResponseEntity<>(accountService.deleteAccountById(id), HttpStatus.OK);
    }
}

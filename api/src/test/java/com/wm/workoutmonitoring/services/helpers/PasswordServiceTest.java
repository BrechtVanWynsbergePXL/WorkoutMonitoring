package com.wm.workoutmonitoring.services.helpers;

import com.wm.workoutmonitoring.exceptions.PasswordException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PasswordServiceTest {
    @Autowired
    private PasswordService passwordService;

    @ParameterizedTest
    @ValueSource(strings = {"test;098f6bcd4621d373cade4e832627b4f6", "password;5f4dcc3b5aa765d61d8327deb882cf99", "Test1234/;ec55d4d5896f0a8f05ff2388126e172d"})
    public void hashPasswordShouldHashInputCorrectly(String input) throws PasswordException {
        String[] args = input.split(";");
        String hashedPw = passwordService.hashPassword(args[0]);
        assertEquals(args[1], hashedPw);
    }
}

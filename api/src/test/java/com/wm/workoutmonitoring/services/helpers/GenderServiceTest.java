package com.wm.workoutmonitoring.services.helpers;

import com.wm.workoutmonitoring.models.Gender;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GenderServiceTest {
    @Autowired
    private GenderService genderService;

    @ParameterizedTest
    @ValueSource(strings = {"male", "MALE", "m", "M"})
    public void serviceShouldReturnMaleOnMaleString(String input) {
        Gender gender = genderService.determineGender(input);
        assertEquals(Gender.MALE, gender);
    }

    @ParameterizedTest
    @ValueSource(strings = {"female", "FEMALE", "f", "F"})
    public void serviceShouldReturnFemaleOnFemaleString(String input) {
        Gender gender = genderService.determineGender(input);
        assertEquals(Gender.FEMALE, gender);
    }

    @ParameterizedTest
    @ValueSource(strings = {"random", "gibberish", "undisclosed"})
    public void serviceShouldReturnUndisclosedOnRandomString(String input) {
        Gender gender = genderService.determineGender(input);
        assertEquals(Gender.UNDISCLOSED, gender);
    }
}

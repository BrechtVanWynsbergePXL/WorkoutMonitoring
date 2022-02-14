package com.wm.workoutmonitoring.services.helpers;

import com.wm.workoutmonitoring.exceptions.GenderException;
import com.wm.workoutmonitoring.models.Gender;
import org.springframework.stereotype.Service;

@Service
public class GenderService {
    public Gender determineGender(String gender) {
        switch (gender) {
            case "M":
            case "Male":
            case "m":
            case "male":
                return Gender.MALE;
            case "F":
            case "Female":
            case "f":
            case "female":
                return Gender.FEMALE;
            default:
                return Gender.UNDISCLOSED;
        }
    }
}

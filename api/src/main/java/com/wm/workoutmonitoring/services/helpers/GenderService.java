package com.wm.workoutmonitoring.services.helpers;

import com.wm.workoutmonitoring.models.Gender;
import org.springframework.stereotype.Service;

@Service
public class GenderService {
    public Gender determineGender(String gender) {
        switch (gender.toLowerCase()) {
            case "m":
            case "male":
                return Gender.MALE;
            case "f":
            case "female":
                return Gender.FEMALE;
            default:
                return Gender.UNDISCLOSED;
        }
    }
}

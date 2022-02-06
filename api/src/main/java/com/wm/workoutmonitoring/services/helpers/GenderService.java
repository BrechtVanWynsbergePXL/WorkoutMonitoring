package com.wm.workoutmonitoring.services.helpers;

import com.wm.workoutmonitoring.exceptions.GenderException;
import com.wm.workoutmonitoring.models.Gender;
import org.springframework.stereotype.Service;

@Service
public class GenderService {
    public Gender determineGender(String gender) throws GenderException {
        if(gender.equals("M") || gender.equals("Male") ||
                gender.equals("m") || gender.equals("male")){
            return Gender.MALE;
        } else if (gender.equals("F") || gender.equals("Female") ||
                gender.equals("f") || gender.equals("female")){
            return Gender.FEMALE;
        } else {
            throw new GenderException("Gender cannot be determined with given input");
        }
    }
}

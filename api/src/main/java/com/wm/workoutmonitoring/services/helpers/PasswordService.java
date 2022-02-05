package com.wm.workoutmonitoring.services.helpers;

import com.wm.workoutmonitoring.exceptions.PasswordException;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class PasswordService {
    public String hashPassword(String password) throws PasswordException {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(password.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new PasswordException(e.getMessage());
        }
    }
}

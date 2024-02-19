package com.jobintech.jitpath.utils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CredentialsUtil {

    private static final String domain = "jobintech.ma";
    private static final SecureRandom random = new SecureRandom();

    public static String generateEmail(String firstName, String lastName){
        return firstName.toLowerCase()+"."+lastName.toLowerCase()+"@jobintech.ma" ;
    }

    public static String generateSecurePassword(int length) {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = upperCaseLetters.toLowerCase();
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()_-+=<>?";
        String allAllowedChars = upperCaseLetters + lowerCaseLetters + digits + specialChars;

        List<Character> passwordChars = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            passwordChars.add(allAllowedChars.charAt(random.nextInt(allAllowedChars.length())));
        }


        if (length >= 4) {
            passwordChars.add(upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length())));
            passwordChars.add(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())));
            passwordChars.add(digits.charAt(random.nextInt(digits.length())));
            passwordChars.add(specialChars.charAt(random.nextInt(specialChars.length())));

            Collections.shuffle(passwordChars, random);
        }

        StringBuilder password = new StringBuilder();
        for (Character ch : passwordChars) {
            password.append(ch);
        }
        return password.toString();
    }


}

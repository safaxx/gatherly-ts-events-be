package com.techsisters.gatherly.util;

import java.security.SecureRandom;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtil {

    // Create a single, reusable instance of SecureRandom
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static String ANNONYMOUS = "annonymous";

    public static String getLoginUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth instanceof AnonymousAuthenticationToken) {
            return ANNONYMOUS;
        } else {
            return auth.getName();
        }
    }

    public static boolean isAnnonymous() {
        return StringUtils.equals(ANNONYMOUS, getLoginUsername());
    }

    /**
     * Generates a 6-digit (000000-999999) verification code.
     * 
     * @return A 6-digit string code.
     */
    public static int generate6DigitCode() {
        // Generate a random integer from 0 to 999,999
        int number = SECURE_RANDOM.nextInt(1_000_000);
        return number;
    }

}

package com.techsisters.gatherly.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtil {

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

}

package com.sandun.wikiadminlogin.service;

import org.springframework.stereotype.Service;

/*
 * Name: Sandun Withana Arachchi
 * Student ID: 1591903
 * BIT235 Assessment 2 - Part A
 *
 * This controller handles requests related to the administrator login.
 */

@Service
public class LoginService {

    // Hard-coded username required for Part A of the assessment.
    private final String validUsername = "sandun";

    // Hard-coded password required for Part A of the assessment.
    private final String validPassword = "123";

    // Checks whether the submitted username and password match
    // the accepted credentials.
    public boolean authenticate(String username, String password) {

        return validUsername.equals(username)
                && validPassword.equals(password);
    }
}
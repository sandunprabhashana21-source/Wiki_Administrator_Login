package com.sandun.wikiadminlogin.controller;

import com.sandun.wikiadminlogin.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Name: Sandun Withana Arachchi
 * Student ID: 1591903
 * BIT235 Assessment 2 - Part A
 *
 * This controller handles requests related to the administrator login.
 */

@Controller
public class LoginController {

    private final LoginService loginService;

    // Constructor injection is used to provide the LoginService to this controller.
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // Displays the login page when the user visits the root URL.
    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    // Processes the username and password submitted by the login form.
    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        // The service checks whether the supplied credentials are correct.
        boolean authenticated = loginService.authenticate(username, password);

        // If authentication is successful, display the welcome page.
        if (authenticated) {
            model.addAttribute("username", username);
            return "welcome";
        }

        // If authentication fails, display the error page.
        return "error";
    }
}
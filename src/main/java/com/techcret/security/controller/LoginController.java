package com.techcret.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @GetMapping(value = "/login")
    public String getLoginPage(@RequestParam Optional<String> error) {
        LOGGER.debug("Getting login page, error={}", error);
        return "/auth/login";
    }

}

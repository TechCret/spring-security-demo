package com.techcret.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Secured("ROLE_USER")
    @GetMapping(value = "/user/profile")
    public String profile() {
        return "/user/profile";
    }

}

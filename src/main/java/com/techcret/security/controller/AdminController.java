package com.techcret.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/admin/profile")
    public String profile() {
        return "/admin/profile";
    }

}

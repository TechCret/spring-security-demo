package com.techcret.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

    @GetMapping(value = "/public/home")
    public String home() {
        return "/public/home";
    }

}

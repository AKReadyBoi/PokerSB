package com.ryabov.pokersb.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoginPageController {
    @GetMapping
    public String login() {
        return "login";
    }
}

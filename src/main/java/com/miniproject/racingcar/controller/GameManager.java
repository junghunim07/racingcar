package com.miniproject.racingcar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameManager {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}

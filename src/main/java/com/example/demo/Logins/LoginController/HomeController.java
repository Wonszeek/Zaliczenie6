package com.example.demo.Logins.LoginController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/index2")
    public String index2() {
        return "index2";
    }
    @GetMapping("/settings")
    public String settings() {
        return "settings";
    }
}

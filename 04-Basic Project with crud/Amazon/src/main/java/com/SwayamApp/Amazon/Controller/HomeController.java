package com.SwayamApp.Amazon.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String greet(){
        return "Welcome to Amazon! ";
    }

    @RequestMapping("/about")
    public String about() {
        return "We don't sell we scam! ";
    }
}

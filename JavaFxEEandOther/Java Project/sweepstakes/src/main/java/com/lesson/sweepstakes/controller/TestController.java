package com.lesson.sweepstakes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping
    public String pageForAuthenticatedUsers(){
        return "secured part of web" ;
    }

    @PostMapping
    public String postpageForAuthenticatedUsers(){
        return "secured part of web" ;
    }
}



























/*
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        return "Saved";
    }*/

  /*  @GetMapping
    public String greeting() {

        return "index";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return getAllUsers();

    }
}*/
package com.lesson.sweepstakes.controllers;

import com.lesson.sweepstakes.accessingdatamysql.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/")

public class MainController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam String name, @RequestParam String email) {

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        return "Saved";
    }

    @GetMapping
    public String greeting() {

        return "index";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return getAllUsers();

    }
}
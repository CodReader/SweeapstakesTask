package com.lesson.sweepstakes.controller;

/*import com.lesson.sweepstakes.dao.User;*/
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RestController
public class MainController {

    @GetMapping("/")
    public String homePage()
    {
       return "home";
   }

    @GetMapping("/authenticated")
    public String pageForAuthenticatedUsers(){
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
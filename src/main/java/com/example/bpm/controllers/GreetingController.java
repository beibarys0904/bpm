package com.example.bpm.controllers;

import com.example.bpm.models.User;
import com.example.bpm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String greeting(
                           Map<String, Object> model
    ){
//        model.addAttribute("name", name);
//        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<User> users = userRepository.findAll();
        model.put("users", users);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name,
                      @RequestParam String email,
                      Map<String, Object> model){
        User user = new User(name, email);
        userRepository.save(user);

        Iterable<User> users = userRepository.findAll();
        model.put("users", users);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String name, Map<String, Object> model){
        Iterable<User> users = userRepository.findByName(name);
        model.put("users", users);
        return "main";
    }

    @GetMapping("filter-2")
    public String searchByEmail(@RequestParam String email, Map<String, Object> model){
        List<User> users = userRepository.findByEmail(email);
        model.put("users", users);
        return "main";
    }


}

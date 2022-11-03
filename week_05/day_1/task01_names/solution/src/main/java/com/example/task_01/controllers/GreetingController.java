package com.example.task_01.controllers;

import com.example.task_01.models.Celebration;
import com.example.task_01.models.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greeting")
public class GreetingController {

    // Step 1 - returning String
//    @GetMapping
//    public String greet(){
//        return "Good afternoon, Colin!";
//    }

//    // Step 2 - return POJO
//    @GetMapping
//    public Greeting greet(){
//        return new Greeting("Colin", "afternoon");
//    }

    // Extension 1 - Adding @RequestParam
    @GetMapping
    public Greeting greet(@RequestParam String timeOfDay){
        return new Greeting("Colin", timeOfDay);
    }

    // Extension 2 - Celebration DTO
    @GetMapping(value = "/christmas")
    public Celebration festiveGreeting(){
        return new Celebration("Merry Christmas!");
    }

}

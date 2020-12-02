package ru.yudin.springboot.demo.springbootapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${coach.team}")
    private String coachTeam;

    @GetMapping("/")
    public String sayHello() {
        return "Hello from MOON";
    }

    @GetMapping("/workout")
    public String sayDailyWorkout() {
        return "daily workout!!!";
    }

    @GetMapping("/test")
    public String sayDTest() {
        return coachName + " " + coachTeam;
    }
}

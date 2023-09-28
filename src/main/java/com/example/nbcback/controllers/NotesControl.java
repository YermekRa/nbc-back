package com.example.nbcback.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class NotesControl {
    @GetMapping
    public String greet(@RequestParam("name") String name) {
        return "Hello, " + name;
    }

    @GetMapping("/full")
    public String fullGreeting(@RequestParam("name") String name,
                               @RequestParam("surname") String surname) {
        return "Nice to meet you, " + name + " " + surname;
    }

    @GetMapping("/{name}")
    public String greetWithPathVariable(@PathVariable("name") String name) {
        return "Hello, " + name;
    }

}

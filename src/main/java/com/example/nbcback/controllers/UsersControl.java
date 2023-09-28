package com.example.nbcback.controllers;

import com.example.nbcback.model.Users;
import com.example.nbcback.service.impl.UsersS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(tags = {"USERS"}, description = "For user control")
public class UsersControl {

    @Autowired
    private UsersS usersS;

    @GetMapping
    @ApiOperation(value = "Get user list")
    public List<Users> findAll() {
        return usersS.findAll();
    }

    @GetMapping("/count")
    @ApiOperation(value = "Users' detail information")
    public Long findCount() {
        return usersS.findCount();
    }

    @GetMapping("/{login}")
    @ApiOperation(value = "Get user by login")
    public Users findById(@PathVariable String login) { return usersS.findByLogin(login.toUpperCase()); }

    @PostMapping()
    @ApiOperation(value = "Create user")
    public Users save(@Valid @RequestBody Users users) {
        return usersS.save(users);
    }

    @DeleteMapping("/{login}")
    @ApiOperation(value = "Delete user")
    public String delete(@PathVariable String login) {

        return usersS.delete(login.toUpperCase());
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

package com.example.nbcback.service;

import com.example.nbcback.model.Users;

import java.util.List;

public interface IUsers {
    List<Users> findAll();

    Long findCount();

    Users findByLogin(String login);

    Users save(Users user);

    String delete(String login);
}

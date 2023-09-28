package com.example.nbcback.service.impl;

import com.example.nbcback.model.Users;
import com.example.nbcback.repositories.UsersR;
import com.example.nbcback.service.IUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersS implements IUsers {
    @Autowired
    UsersR usersR;

    @Override
    public List<Users> findAll(){
        return usersR.findAll();
    }

    @Override
    public Long findCount(){
        return usersR.count();
    }

    @Override
    public Users findByLogin(String login) {
        return usersR.findByLogin(login);
    }

    @Override
    public Users save(Users user) {
        usersR.save(user);
        return user;
    }

    @Override
    public String delete(String login) {
        usersR.delete(login);
        return "User (" + login + ") was deleted";
    }

}

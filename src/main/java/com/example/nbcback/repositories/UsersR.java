package com.example.nbcback.repositories;

import com.example.nbcback.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersR extends JpaRepository<Users, Integer>{

    void delete(String login);

    Users findByLogin(String login);
}

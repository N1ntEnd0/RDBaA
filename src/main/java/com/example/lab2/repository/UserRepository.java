package com.example.lab2.repository;

import com.example.lab2.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
    Users getByLoginAndPassword(String login, String password);
}

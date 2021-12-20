package com.example.lab2.controllers;

import com.example.lab2.DTO.UserDTO;
import com.example.lab2.entity.Music;
import com.example.lab2.entity.Users;
import com.example.lab2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/reg")
    public ResponseEntity<String> reg(@RequestBody UserDTO userDTO) {
        Users user = userRepository.getByLoginAndPassword(userDTO.getLogin(), userDTO.getPassword());
        if (user == null) {
            Users users = new Users();
            users.setLogin(userDTO.getLogin());
            users.setPassword(userDTO.getPassword());
            userRepository.save(users);
            return new ResponseEntity("Зарегистрирован", HttpStatus.OK);
        } else {
            return new ResponseEntity("Пользователь с таким логином уже зарегистрирован", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        Users user = userRepository.getByLoginAndPassword(userDTO.getLogin(), userDTO.getPassword());
        if (user == null) {
            return new ResponseEntity("Неверный логин пароль", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity("Успешно", HttpStatus.OK);
        }
    }
}

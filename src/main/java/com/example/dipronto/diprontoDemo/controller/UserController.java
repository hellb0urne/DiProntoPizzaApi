package com.example.dipronto.diprontoDemo.controller;

import com.example.dipronto.diprontoDemo.entity.User;
import com.example.dipronto.diprontoDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/agregarUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }


}

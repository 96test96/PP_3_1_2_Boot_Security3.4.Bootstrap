package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.security.Principal;
@RequestMapping("/api")
@RestController
public class RestUserController {
    private final UserService userService;

    public RestUserController(UserService userService) { this.userService = userService; }

    @GetMapping("/user")
    public ResponseEntity<User> getUserAuth(Principal principal) {
        return new ResponseEntity<>(userService.findByUserName(principal.getName()), HttpStatus.OK);
    }
}

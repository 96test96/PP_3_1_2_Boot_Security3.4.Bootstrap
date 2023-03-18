package ru.kata.spring.boot_security.demo.configs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kata.spring.boot_security.demo.configs.entity.User;
import ru.kata.spring.boot_security.demo.configs.service.UserService;

@Controller
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(ModelMap model){
        model.addAttribute("allUsers", userService.getAllUsers());
    return "users";
    }


    @GetMapping("/newUser")
    public String addNewUser(ModelMap model){
        model.addAttribute("user", new User());
        return "new_user";
    }
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("user", userService.getUserById(id));
        return "update_user";
    }
    @PostMapping("/updateUser")
    public String saveUpdateUser( @ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("/addUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }

    @PostMapping ("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}

package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService usersService;
    private final RoleService roleService;


    @Autowired
    public AdminController(UserService usersService, RoleService roleService) {
        this.usersService = usersService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String showAllUsers(Model model){
        model.addAttribute("users", usersService.getAllUsers());
        return "users";
    }
    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAll());
        return "new_user";
    }
    @PostMapping("/addUser")
    public String save(@ModelAttribute("user") User user){
        usersService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", usersService.getUserById(id));
        model.addAttribute("allRoles", roleService.getAll());
        return "update_user";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("update") User user) {
        usersService.updateUser(user);
        return "redirect:/admin";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        usersService.deleteUser(id);
        return "redirect:/admin";
    }
}

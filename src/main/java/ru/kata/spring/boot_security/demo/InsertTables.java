package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.HashSet;
import java.util.Set;


@Component
public class InsertTables implements CommandLineRunner {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public InsertTables(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @Override
    public void run(String... args) throws Exception {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleService.saveRole(roleAdmin);
        roleService.saveRole(roleUser);
        Set<Role> roles = new HashSet<>();
        roles.add(roleAdmin);
        roles.add(roleUser);
        User user = new User("Ivan", "Ivanov", "ivanov@mail.ru", 32, "123", roles);
        userService.addUser(user);
    }
}

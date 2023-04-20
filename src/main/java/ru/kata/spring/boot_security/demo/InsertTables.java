package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class InsertTables implements CommandLineRunner {
    private final UserServiceImpl userServiceImp;
    private final RoleServiceImpl roleServiceImp;

    @Autowired
    public InsertTables(UserServiceImpl userServiceImp, RoleServiceImpl roleServiceImp) {
        this.userServiceImp = userServiceImp;
        this.roleServiceImp = roleServiceImp;
    }


    @Override
    public void run(String... args) throws Exception {
        Role role = new Role("ROLE_ADMIN");
        Role role1 = new Role("ROLE_USER");
        roleServiceImp.saveRole(role);
        roleServiceImp.saveRole(role1);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        roles.add(role1);
        User user = new User("Ivan", "Ivanov", "ivanov@mail.ru", 32, "123", roles);
        userServiceImp.addUser(user);

//        Set<Role> roles2 = new HashSet<>();
//        roles2.add(role1);
//        User user2 = new User("Sergei", "Ivanov", "ivanov@mail.ru", 32, "1234", roles2);
//        userServiceImp.addUser(user2);
    }
}

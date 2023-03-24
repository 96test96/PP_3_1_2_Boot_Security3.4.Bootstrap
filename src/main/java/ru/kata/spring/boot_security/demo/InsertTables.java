package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;


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
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        User user = new User("Ivan", "Ivanov", "ivanov@mail.ru", 32, "$2a$12$aAdW2J7Ae77GC6HLxDm0HewNliwkrGjod.4p0kW.ayijMpJDiZlEy", roles);
        userServiceImp.addUser(user);

        roleServiceImp.saveRole(role1);
        List<Role> roles2 = new ArrayList<>();
        roles2.add(role1);
        User user2 = new User("Sergei", "Ivanov", "ivanov@mail.ru", 32, "$2a$12$1ooAl/sSgfq24NNoGa/9zeL4l14XZRAyZ//zZxbPIxXYU96gDxyXq", roles2);
        userServiceImp.addUser(user2);
    }
}

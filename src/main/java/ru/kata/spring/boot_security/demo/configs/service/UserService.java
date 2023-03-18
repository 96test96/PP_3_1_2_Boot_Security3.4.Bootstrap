package ru.kata.spring.boot_security.demo.configs.service;

import ru.kata.spring.boot_security.demo.configs.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void addUser(User user);
    public void updateUser(User user);

    public User getUserById(int id);

    public void deleteUser(int id);
}

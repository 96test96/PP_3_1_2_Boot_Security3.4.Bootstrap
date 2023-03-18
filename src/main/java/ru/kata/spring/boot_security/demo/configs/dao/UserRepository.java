package ru.kata.spring.boot_security.demo.configs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.configs.entity.User;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,Integer> {
public User findByName(String username);

}

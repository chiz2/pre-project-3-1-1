package ru.javamentor.preproject311.service;

import ru.javamentor.preproject311.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void deleteUser(Integer id);

    void updateUser(Integer id, User updatedUser);

    User getUserById(Integer id);

    List<User> getAllUsers();
}

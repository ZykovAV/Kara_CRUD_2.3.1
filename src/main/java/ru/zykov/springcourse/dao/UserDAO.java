package ru.zykov.springcourse.dao;

import ru.zykov.springcourse.models.User;

import java.util.List;

public interface UserDAO {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastname, byte age);

    void removeUserById(long id);


    List<User> getAllUsers();

    void cleanUsersTable();

}

package ru.zykov.springcourse.connect_db;

import ru.zykov.springcourse.models.User; /* a pochem import esli package, a htoya drugoy da?*/

import java.util.List;

public interface connectDAO {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastname, byte age);

    void removeUserById(long id);


    List<User> getAllUsers();

    void cleanUsersTable();
}

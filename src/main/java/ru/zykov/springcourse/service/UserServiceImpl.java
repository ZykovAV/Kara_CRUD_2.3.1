package ru.zykov.springcourse.service;

import ru.zykov.springcourse.connect_db.connectDAOImpl;
import ru.zykov.springcourse.models.User;

import java.util.List;

public class UserServiceImpl implements UserService{

    private static ru.zykov.springcourse.connect_db.connectDAO connectDAO = new connectDAOImpl();

    @Override
    public void createUsersTable() {
        connectDAO.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        connectDAO.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        connectDAO.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        connectDAO.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return connectDAO.getAllUsers();
    }

    @Override
    public void cleanUsersTable() { connectDAO.cleanUsersTable(); }

}

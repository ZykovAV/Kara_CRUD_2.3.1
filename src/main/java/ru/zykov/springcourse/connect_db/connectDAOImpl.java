package ru.zykov.springcourse.connect_db;

import org.hibernate.Session;
import ru.zykov.springcourse.models.User;

import java.util.List;

public class connectDAOImpl implements connectDAO{

    @Override
    public void createUsersTable() {
        try (Session session = Util.getFactory().openSession()) {
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS my_db.table (" +
                            "  `id` INT NOT NULL AUTO_INCREMENT," +
                            "  `name` VARCHAR(45) NOT NULL," +
                            "  `surname` VARCHAR(45) NOT NULL," +
                            "  `age` INT(3) NOT NULL," +
                            "  PRIMARY KEY (`id`)," +
                            "  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);")
                    .executeUpdate();
            System.out.println("БД создана!");
            session.getTransaction().commit();
            System.out.println("2");
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getFactory().openSession()) {
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS my_db.table")
                    .executeUpdate();
            session.getTransaction().commit();
            System.out.println("БД удалена!");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String surname, byte age) {
        User user = new User(name, surname, age);
        try (Session session = Util.getFactory().openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            System.out.println("Сохранение в БД выполнено!");
        } catch (Exception e) {
            System.out.println("exception save user");
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getFactory().openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }
            session.getTransaction().commit();
            System.out.println("Удаление выполнено!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users;
        try (Session session = Util.getFactory().openSession()) {
            session.beginTransaction();
            System.out.println("rabotaet metid all users");
            users = session.createQuery("from User").getResultList();
            session.getTransaction().commit();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("delete User")
                    .executeUpdate();
            session.getTransaction().commit();
            System.out.println("Удаление выполнено!");
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}

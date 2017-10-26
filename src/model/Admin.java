package model;

import controller.AdminController;
import java.sql.SQLException;

public class Admin extends User {
    AdminController adminController = new AdminController();

    public Admin(String name, String login, String password, int id) {
        super(name, login, password, id);
    }

    public static void registration(String name, String login, String password) throws SQLException {//регистрация администратора
        AdminController.adminRegistration(name, login, password);
    }

    public static Admin authorization(String login, String password) throws SQLException {//авторизация представителя саммита
       return AdminController.adminAuthorization(login, password);
    }

    public void removeLeader(String login) throws SQLException {
        adminController.removeLeader(login);
    }
}

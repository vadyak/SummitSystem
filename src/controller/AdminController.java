package controller;

import model.Admin;
import view.AdminView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminController {
    static AdminView view = new AdminView();

    public static void adminRegistration(String name, String login, String password) throws SQLException {
        String query = "SELECT login FROM summitsystemdb.users WHERE login = " + "'" + login + "'";

        if (DBProcessor.dbQuery(query).next()) {
            view.loginExist();
        } else {
            DBProcessor.dbUpdate("INSERT INTO summitsystemdb.users (name, login, password) VALUES ('" + name + "' , '" + login + "' , '" + password + "')");
            view.registrationSuccess(login);
        }
    }

    public static Admin adminAuthorization(String login, String password) throws SQLException {//авторизация представителя саммита
        String query = "SELECT name, id FROM summitsystemdb.users WHERE login = " + "'" + login + "' AND password = '" + password + "'";
        ResultSet rs = DBProcessor.dbQuery(query);

        if (rs.next()) {
            String name = rs.getString("name");
            int id = rs.getInt("id");
            view.authorizationSuccess(login);
            return new Admin(name, login, password, id);
        } else {
            view.invalidLoginOrPassword();
        }
        return null;
    }

    public void removeLeader(String login) throws SQLException {
        String findLeader = "SELECT id FROM summitsystemdb.users WHERE login = '" + login + "'";

        ResultSet rs = DBProcessor.dbQuery(findLeader);
        if (rs.next()){
            int id = rs.getInt("id");
            DBProcessor.dbUpdate("DELETE FROM summitsystemdb.users WHERE login = '" + login + "'");
            DBProcessor.dbUpdate("DELETE FROM summitsystemdb.request WHERE leaderID = '" + id + "'");
            view.leaderIsRemoved(login);
        }
        else
            view.leaderDoesNotExist(login);
    }
}

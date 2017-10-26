package controller;

import model.Leader;
import view.LeaderView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaderController {
    static LeaderView view = new LeaderView();

    public static void leaderRegistration(String name, String login, String password) throws SQLException {
        String query = "SELECT login FROM summitsystemdb.users WHERE login = " + "'" + login + "'";
        if (DBProcessor.dbQuery(query).next()) {
            view.loginExist();
        } else {
            DBProcessor.dbUpdate("INSERT INTO summitsystemdb.users (name, login, password) VALUES ('" + name + "' , '" + login + "' , '" + password + "')");
            view.registrationSuccess(login);
        }
    }

    public static Leader leaderAuthorization(String login, String password) throws SQLException {//авторизация представителя саммита
        String query = "SELECT name, id FROM summitsystemdb.users WHERE login = " + "'" + login + "' AND password = '" + password + "'";
        ResultSet rs = DBProcessor.dbQuery(query);
        if (rs.next()) {
            String name = rs.getString("name");
            int id = rs.getInt("id");
            view.authorizationSuccess(login);
            return new Leader(name, login, password, id);
        } else {
            view.invalidLoginOrPassword();
        }
        return null;
    }

    public void addNewRequest(String country, int month, int leaderId, String intervalDate) throws SQLException {
        String query = "SELECT leaderID FROM summitsystemdb.request WHERE country = '" + country + "' AND month = '" + month + "' AND leaderID = '" + leaderId + "'";
        String newQuery;

        if (DBProcessor.dbQuery(query).next()) {
            newQuery = "UPDATE summitsystemdb.request SET intervalDate = CONCAT(intervalDate, '" + intervalDate + "') WHERE country = '" + country + "' AND month = '" + month + "' AND leaderID = '" + leaderId + "'";
            DBProcessor.dbUpdate(newQuery);
        } else {
            newQuery = "INSERT INTO summitsystemdb.request (leaderID, country, month, intervalDate) VALUES ('" + leaderId + "' , '" + country.toUpperCase() + "' , '" + month + "' , '" + intervalDate + "')";
            DBProcessor.dbUpdate(newQuery);
        }
    }
}

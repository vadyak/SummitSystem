package controller;

import java.sql.*;

public class DBProcessor {
    private static Connection connection;
    private static final String url = "jdbc:mysql://localhost:3306/summitsystemdb?useSSL=false";
    private static final String user = "root";
    private static final String password = "root";

    private static void getConnection(String url, String login, String password) throws SQLException {
        if (connection != null) return;
        connection = DriverManager.getConnection(url, login, password);
    }

    private static void createConnect() throws SQLException {
        getConnection(url, user, password);
    }

    public static ResultSet dbQuery(String query) throws SQLException {
        createConnect();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public static int dbUpdate(String query) throws SQLException {
        createConnect();
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }
}

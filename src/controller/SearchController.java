package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchController {

    public ResultSet findFinalResult() throws SQLException {
       ResultSet res = DBProcessor.dbQuery("SELECT DISTINCT country, month FROM summitsystemdb.request WHERE (month, country) IN (SELECT month, country FROM summitsystemdb.request GROUP BY month, country HAVING count(*) = (SELECT count(DISTINCT leaderID) FROM summitsystemdb.request))");
       return res;
    }

    public ResultSet selectIntervalDate(String country, int month) throws SQLException {
        String query = "SELECT intervalDate FROM summitsystemdb.request WHERE country = '" + country + "' and month = '" + month + "'";
        ResultSet rs = DBProcessor.dbQuery(query);
        return rs;
    }

}

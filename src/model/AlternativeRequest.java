package model;

import java.sql.SQLException;

interface AlternativeRequest {
    void addRequest(String country, int month, int startDate, int finishDate) throws SQLException;
}

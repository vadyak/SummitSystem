package model;

import controller.LeaderController;
import view.LeaderView;

import java.sql.SQLException;

public class Leader extends User implements AlternativeRequest {
    LeaderController leaderController = new LeaderController();
    LeaderView view = new LeaderView();

    public Leader(String name, String login, String password, int id) {
        super(name, login, password, id);
    }

    public static void registration(String name, String login, String password) throws SQLException {//регистрация представителя саммита
        LeaderController.leaderRegistration(name, login, password);
    }

    public static Leader authorization(String login, String password) throws SQLException {//авторизация представителя саммита
        return LeaderController.leaderAuthorization(login, password);
    }

    @Override
    public void addRequest(String country, int month, int startDate, int finishDate) throws SQLException {//добавление нового варианта места проведения саммита
        if (month < 1 || month > 12) {
            view.monthRangeError();
            return;
        }
        if (startDate < 1 || startDate > 31) {
            view.startDateError();
            return;
        }
        if (finishDate < 1 || finishDate > 31) {
            view.finishDateError();
            return;
        }
        if (startDate > finishDate) {
            view.matchingDateError();
            return;
        }

        String intervalDate = startDate + "-" + finishDate + ",";
        leaderController.addNewRequest(country, month, getId(), intervalDate);
    }

    @Override
    public String toString() {
        return getId() + " " + getName() + " " + getLogin() + " " + getPassword();
    }
}

package view;

public class LeaderView {
    public void loginExist() {
        System.out.println("Пользователь с таким логином уже существует");
    }

    public void registrationSuccess(String login) {
        System.out.println("Пользователь с логином " + login + " зарегистрирован");
    }

    public void authorizationSuccess(String login) {
        System.out.println("Пользователь " + login + " прошел авторизацию");
    }

    public void invalidLoginOrPassword() {
        System.out.println("Пара логин/пароль не совпадает");
    }

    public void monthRangeError(){
        System.out.println("Введите номер месяца с 1 до 12");
    }

    public void startDateError(){
        System.out.println("Введите начальную дату с 1 по 31");
    }

    public void finishDateError(){
        System.out.println("Введите начальную дату с 1 по 31");
    }

    public void matchingDateError(){
        System.out.println("Начальная дата должна быть меньше или равна конечной");
    }
}

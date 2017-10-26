package view;

public class AdminView {
    public void loginExist(){
        System.out.println("Администратор с таким логином уже существует");
    }

    public void registrationSuccess(String login){
        System.out.println("Администратор с логином " + login + " зарегистрирован");
    }

    public void authorizationSuccess(String login){
        System.out.println("Администратор " + login + " прошел авторизацию");
    }

    public void invalidLoginOrPassword(){
        System.out.println("Пара логин/пароль не совпадает");
    }

    public void leaderIsRemoved(String login){
        System.out.println("Пользователь с логином " + login + " удален");
    }

    public void leaderDoesNotExist(String login){
        System.out.println("Пользователя с логином " + login + " не существует");
    }
}

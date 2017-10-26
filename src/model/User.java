package model;

abstract class User {
    private String name;
    private String login;
    private String password;
    private int id;

    public User(String name, String login, String password, int id) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

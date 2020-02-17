package ch.botwat;

public class User {
    public int id;
    public String discordHandle;
    public String email;
    public String name;
    public String password;
    public String token;
    public Object permissions;

    public User(String userName, String pass) {
        name = userName;
        password = pass;
    }
    public User(){}
}

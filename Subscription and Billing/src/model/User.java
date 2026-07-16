package model;

public class User {

    private int userId;
    private String name;
    private String email;
    private String password;
    private Role role;

    public User(int userId, String name, String email, String password, Role role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public int getUserId(){

        return userId;
    }

    public String getName() {

        return name;
    }

    public String getEmail() {

        return email;
    }

    public String getPassword() {
        return password;

    }

    public Role getRole() {
        return role;
    }

}
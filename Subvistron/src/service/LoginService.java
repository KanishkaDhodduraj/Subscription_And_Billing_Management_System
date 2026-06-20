package service;

import model.User;

public class LoginService {

    public boolean login(User user, String email, String password) {

        return user.getEmail().equals(email);
    }
}
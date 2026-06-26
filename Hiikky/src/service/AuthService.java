package service;

import model.User;

public class AuthService {
    public boolean login(User user, String email, String password) {
        return user.getEmail().equals(email) && user.getPassword().equals(password);
    }
}
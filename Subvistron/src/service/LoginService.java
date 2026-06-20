package service;

import model.User;
import java.util.ArrayList;

public class LoginService {
    public User login(ArrayList<User> users, String email,
            String password) {
        for(User user : users) {

            if(user.getEmail().equals(email)
                    &&
                    user.getPassword().equals(password)) {

                return user;
            }
        }

        return null;

    }
}
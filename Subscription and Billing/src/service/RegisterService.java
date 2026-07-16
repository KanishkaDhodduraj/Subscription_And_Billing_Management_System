package service;

import model.Role;
import model.User;

import java.util.ArrayList;

public class RegisterService {

    private ArrayList<User> users = new ArrayList<>();

    public void registerUser(User user) {

        for(User u : users) {

            if(u.getEmail().equals(user.getEmail())) {
                System.out.println("Email already exists!");
                return;
            }
        }

        users.add(user);

        System.out.println("Registration Successful");
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
package service;

import model.User;
import java.util.ArrayList;

public class UserService {

    private ArrayList<User> users = new ArrayList<>();

    public void registerUser(User user) {
        users.add(user);

        System.out.println(user.getName() + " Registered successfully.");
    }

    public void displayUsers() {
        System.out.println("\nRegistered Users");

        for(User user : users) {
            System.out.println(user.getUserId() + " - " + user.getName());
        }
    }
}
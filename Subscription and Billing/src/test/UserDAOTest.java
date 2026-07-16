package test;

import dao.UserDAO;
import model.Role;
import model.User;

public class UserDAOTest {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        User user = new User(1, "Kanishka", "kani@gmail.com", "12345", Role.USER);

        dao.addUser(user);
    }
}
package dao;

import database.DBConnection;
import model.User;

import java.sql.*;

public class UserDAO {
    public void addUser(User user) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO users(name,email,password,role) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole().toString());

            ps.executeUpdate();

            System.out.println("User Saved Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewUsers() {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n    USERS     ");
            while (rs.next()) {

                System.out.println(rs.getInt("user_id") + " | " + rs.getString("name") + " | " + rs.getString("email") + " | " + rs.getString("role"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean login(String email, String password) {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
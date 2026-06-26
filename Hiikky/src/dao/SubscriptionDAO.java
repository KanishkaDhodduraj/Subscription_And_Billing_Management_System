package dao;

import database.DBConnection;

import java.sql.*;

public class SubscriptionDAO {

    public void viewSubscriptions() {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM subscriptions";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt("subscription_id") + " | User:" + rs.getInt("user_id") + " | Plan:" + rs.getInt("plan_id") + " | " + rs.getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
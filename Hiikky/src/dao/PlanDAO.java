package dao;

import database.DBConnection;
import model.Plan;

import java.sql.*;
public class PlanDAO {

    public void addPlan(Plan plan) {
        try {

            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO plans(plan_name,price,duration_days) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, plan.getPlanName());
            ps.setDouble(2, plan.getPrice());
            ps.setInt(3, plan.getDurationDays());

            ps.executeUpdate();

            System.out.println("Plan Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewPlans() {

        try {

            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM plans";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("plan_id") + " | " + rs.getString("plan_name")
                                + " | Rs."
                                + rs.getDouble("price")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
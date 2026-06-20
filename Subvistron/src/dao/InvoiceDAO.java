package dao;

import database.DBConnection;

import java.sql.*;

public class InvoiceDAO {

    public void viewInvoices() {

        try {

            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM invoices";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println(rs.getInt("invoice_id") + " | "
                        + rs.getString("invoice_no")
                        + " | Rs." + rs.getDouble("amount") + " | " + rs.getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
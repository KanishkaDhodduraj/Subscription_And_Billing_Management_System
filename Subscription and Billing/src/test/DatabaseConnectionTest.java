package test;

import database.DBConnection;
import java.sql.Connection;

public class DatabaseConnectionTest {

    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();

        if(con != null) {

            System.out.println("Database is Connected Successfully");

        } else {

            System.out.println("Connection is Failed");
        }
    }
}
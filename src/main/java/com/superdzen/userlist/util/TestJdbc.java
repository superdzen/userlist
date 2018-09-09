package com.superdzen.userlist.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {

        String jdbcURL = "jdbc:mysql://localhost:3306/userdb?allowPublicKeyRetrieval=true&useSSL=false";
        String user = "admin";
        String password = "admin";

        System.out.println("Testing connection to DB " + jdbcURL);
        try (Connection connection = DriverManager.getConnection(jdbcURL, user, password);) {
            System.out.println("Connection established.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

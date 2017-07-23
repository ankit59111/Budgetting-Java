package com.ebs.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by gaurav on 01/07/17.
 */
public class DbFactory {

    private static Connection connection;

    public static void setUpMysqlConnection(){
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/ebs_db", "root", "Gunika123");

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
        }
    }

    public static Connection getMySqlConnection() {
        return connection;
    }

    public static void closeMySqlConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

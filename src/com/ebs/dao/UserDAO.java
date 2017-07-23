package com.ebs.dao;

import com.ebs.factory.DbFactory;
import com.ebs.model.AccessLevel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gaurav on 01/07/17.
 */
public class UserDAO {

    public AccessLevel signIn(String username, String password) {
        try {
            if (DbFactory.getMySqlConnection() == null)
                DbFactory.setUpMysqlConnection();

            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select `user_type` from `user` where `user_name` = ? and `user_password` = ?;");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            String userType = "";
            while (resultSet.next()) {
                userType = resultSet.getString("user_type");
            }
            if (userType.equals("Admin"))
                return AccessLevel.ADMIN;
            else if (userType.equals("Director"))
                return AccessLevel.DIRECTOR;
            else if (userType.equals("Proctor"))
                return AccessLevel.PROCTOR;
            else if (userType.equals("Registrar"))
                return AccessLevel.REGISTRAR;
            else return null;

        } catch (SQLException e) {
            return null;
        }
    }

    public String signUpUser(String emailId, String password, String accessLevel) {

        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("insert into `user` (`user_name`,`user_password`,`user_type`) values (?,?,?);");
            statement.setString(1, emailId);
            statement.setString(2, password);
            statement.setString(3, accessLevel);
            System.out.println(statement.toString());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                return "Data Not Stored";
            } else return "Data Stored";

        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1062:
                    return "Duplicate Entry";
                case 1406:
                    return "Data Too Long";
                default:
                    return "Unknown Error";
            }
        }

    }

}

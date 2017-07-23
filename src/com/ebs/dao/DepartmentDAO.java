package com.ebs.dao;

import com.ebs.factory.DbFactory;
import com.ebs.model.Department;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by gaurav on 12/07/17.
 */
public class DepartmentDAO {

    public ObservableList<Department> getDepartmentsList() {
        ArrayList<Department> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select * from department;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                arrayList.add(new Department(resultSet.getInt("department_id"), resultSet.getString("department_name"), resultSet.getLong("allotted_revenue")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

}

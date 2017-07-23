package com.ebs.dao;

import com.ebs.factory.DbFactory;
import com.ebs.factory.IdFactory;
import com.ebs.model.Revenue;
import com.ebs.model.RevenueType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.management.MalformedObjectNameException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Ankit on 7/7/2017.
 */
public class RevenueDAO {

    public ObservableList<Revenue> getMonthRevenuesFromDb(String month) {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.month=?;");
            preparedStatement.setString(1,String.valueOf(IdFactory.getMonthId(month)));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getJanuaryRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.month='1';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getFebruaryRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.month='2';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getMarchRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.month='3';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getAprilRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.month='4';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getMayRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.month='5';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getJuneRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.month='6';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getJulyRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.month='7';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getAugustRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.month='8';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getSeptemberRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.month='9';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getOctoberRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.month='10';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getNovemberRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.month='11';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getDecemberRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.month='12';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getFeesRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.revenue_type='0';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getDonationRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.revenue_type='6';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getGovernmentGrantsRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.revenue_type='7';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getResearchSponsorRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.revenue_type='8';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getOtherIncomeRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id and incoming.revenue_type='9';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getEngineeringRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,allotted_revenue,month from activity natural join department natural join expenditure_type natural join months where activity.department_id = '1' ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("department_name"), resultSet.getString("allotted_revenue"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getMedicalRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select department_id,department_name,allotted_revenue,month from activity natural join department natural join expenditure_type natural join months where activity.department_id = '2'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("department_id"), resultSet.getString("department_name"), resultSet.getString("allotted_revenue"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getManagementRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select department_id,department_name,allotted_revenue,month from activity natural join department natural join expenditure_type natural join months where activity.department_id = '3'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("department_id"), resultSet.getString("department_name"), resultSet.getString("allotted_revenue"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getArtsRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select department_id,department_name,allotted_revenue,month from activity natural join department natural join expenditure_type natural join months where activity.department_id = '4'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("department_id"), resultSet.getString("department_name"), resultSet.getString("allotted_revenue"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getCommerceRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select department_id,department_name,allotted_revenue,month from activity natural join department natural join expenditure_type natural join months where activity.department_id = '5'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("department_id"), resultSet.getString("department_name"), resultSet.getString("allotted_revenue"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getCollegeAdministrationRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select department_id,department_name,allotted_revenue,month from activity natural join department natural join expenditure_type natural join months where activity.department_id = '6'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("department_id"), resultSet.getString("department_name"), resultSet.getString("allotted_revenue"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Revenue> getCcpdRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select department_id,department_name,allotted_revenue,month from activity natural join department natural join expenditure_type natural join months where activity.department_id = '7'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("department_id"), resultSet.getString("department_name"), resultSet.getString("allotted_revenue"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }


    public ObservableList<Revenue> getAllRevenuesFromDb() {
        ArrayList<Revenue> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select incoming_id,months.month as `month`,`revenue_type_name`,`amount` from `incoming`,`revenue_types`,`months` where incoming.revenue_type = revenue_types.revenue_type_id and incoming.month = months.month_id order by incoming_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Revenue(resultSet.getInt("incoming_id"), resultSet.getString("revenue_type_name"), resultSet.getString("amount"), resultSet.getString("month")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<RevenueType> getRevenueTypesList() {
        ArrayList<RevenueType> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select * from revenue_types;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                arrayList.add(new RevenueType(resultSet.getInt("revenue_type_id"), resultSet.getString("revenue_type_name")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public boolean addRevenueToDb(Revenue revenue) {
        try {
            int monthId = IdFactory.getMonthId(revenue.getMonth());
            String revenueTypeId = String.valueOf(IdFactory.getrevenueTypeId(revenue.getType()));
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("insert into incoming (incoming_id,month,revenue_type,amount) values (?,?,?,?);");
            statement.setInt(2, monthId);
            statement.setString(3, revenueTypeId);
            statement.setInt(4, Integer.parseInt(revenue.getAmount()));
            statement.setInt(1, revenue.getRevenueId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                return true;
            } else return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public boolean deleteRevenue(int revenueId) {
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("delete from incoming where incoming_id = ?;");
            statement.setInt(1, revenueId);
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) return true;
            else return false;
        } catch (SQLException e) {
            return false;
        }
    }


}

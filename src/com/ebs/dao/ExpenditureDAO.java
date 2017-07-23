package com.ebs.dao;

import com.ebs.factory.DbFactory;
import com.ebs.factory.IdFactory;
import com.ebs.model.Expenditure;
import com.ebs.model.ExpenditureType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ExpenditureDAO {

    public ObservableList<Expenditure> getJanuaryExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.month_id = '1'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }


    public ObservableList<Expenditure> getFebruaryExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.month_id = '2'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getMarchExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.month_id = '3'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getAprilExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.month_id = '4'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getMayExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.month_id = '5'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getJuneExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.month_id = '6'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getJulyExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.month_id = '7'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getAugustExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.month_id = '8'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getSeptemberExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.month_id = '9'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getOctoberExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.month_id = '10'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getNovemberExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.month_id = '11'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getDecemberExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.month_id = '12'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getEngineeringExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,allotted_revenue,month from activity natural join department natural join expenditure_type natural join months where activity.department_id = '1'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }


    public ObservableList<Expenditure> getMedicalExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.department_id = '2'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }


    public ObservableList<Expenditure> getManagementExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.department_id = '3'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getArtsExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.department_id = '4'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getCommerceExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.department_id = '5'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getAdministrationExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.department_id = '6'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getCcpdExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.department_id = '7'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }


    public ObservableList<Expenditure> getOverallDepartmentExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months order By activity_id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }



    public ObservableList<Expenditure> getDebtChargesExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.expenditure_type_id='1'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getFacultySalaryExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.expenditure_type_id='2'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getInfrastructureExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.expenditure_type_id='3'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }


    public ObservableList<Expenditure> getEventExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.expenditure_type_id='4'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }


    public ObservableList<Expenditure> getArtlaboratoryExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.expenditure_type_id='5'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }


    public ObservableList<Expenditure> getPlacementDriveExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.expenditure_type_id='6'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }



    public ObservableList<Expenditure> getMiscellaneousExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.expenditure_type_id='7'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getTransportationExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.expenditure_type_id='8'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }

    public ObservableList<Expenditure> getStudentDevelopmentExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity_id,department_name,expenditure_type_name,amount,month from activity natural join department natural join expenditure_type natural join months where activity.expenditure_type_id='9'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);

    }


    public ObservableList<Expenditure> getAllExpendituresFromDb() {
        ArrayList<Expenditure> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("select activity.activity_id,expenditure_type.expenditure_type_name,department.department_name,activity.amount,months.month FROM activity INNER JOIN expenditure_type ON activity.expenditure_type_id=expenditure_type.expenditure_type_id INNER JOIN department ON activity.department_id=department.department_id INNER JOIN months ON activity.month_id = months.month_id;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(new Expenditure(resultSet.getInt("activity_id"), resultSet.getString("department_name"), resultSet.getString("month"), resultSet.getString("expenditure_type_name"), resultSet.getString("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<ExpenditureType> getExpenditureTypesList() {
        ArrayList<ExpenditureType> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DbFactory.getMySqlConnection().prepareStatement("select * from expenditure_type;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                arrayList.add(new ExpenditureType(resultSet.getInt("expenditure_type_id"), resultSet.getString("expenditure_type_name")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(arrayList);
    }

    public boolean addExpenditureToDb(Expenditure expenditure) {
        try {
            int monthId = IdFactory.getMonthId(expenditure.getMonth());
            String expenditureTypeId = String.valueOf(IdFactory.getExpenditureId(expenditure.getActivityName()));
            int departmentId = IdFactory.getDepartmentId(expenditure.getDepartmentName());
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("insert into activity (activity_id,expenditure_type_id,department_id,month_id,amount) values (?,?,?,?,?);");
            statement.setInt(1, expenditure.getExpenditureId());
            statement.setString(2, expenditureTypeId);
            statement.setInt(3, departmentId);
            statement.setInt(4, monthId);
            statement.setInt(5, Integer.parseInt(expenditure.getAmount()));
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) return true;
            else return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteExpenditure(int expenditureId) {
        try {
            PreparedStatement statement = DbFactory.getMySqlConnection().prepareStatement("delete from activity where activity_id  = ?;");
            statement.setInt(1, expenditureId);
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) return true;
            else return false;
        } catch (SQLException e) {
            return false;
        }
    }

}
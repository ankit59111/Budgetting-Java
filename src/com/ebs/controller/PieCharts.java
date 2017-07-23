package com.ebs.controller;

import com.ebs.dao.DepartmentDAO;
import com.ebs.dao.ExpenditureDAO;
import com.ebs.model.Department;
import com.ebs.model.Expenditure;
import com.ebs.model.ExpenditureType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ani41 on 7/7/2017.
 */
public class PieCharts implements Initializable {

    public Tab monthTab;
    public Tab categoricalTab;
    public Tab departmentalTab;
    public PieChart monthlyPieChart;
    public PieChart categoricalPieChart;
    public PieChart departmentalPieChart;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void monthTabClicked() {
        ObservableList<PieChart.Data> piechartData = FXCollections.observableArrayList();
        ObservableList<Expenditure> expenditureObservableList = new ExpenditureDAO().getAllExpendituresFromDb();
        ObservableList<String> monthsObservableList = FXCollections.observableArrayList("January","February","March","April","May","June","July","August","September","October","November","December");
        for (int i = 0; i < monthsObservableList.size(); i++) {
            long sum = 0;
            for (int j = 0; j < expenditureObservableList.size(); j++) {
                if (expenditureObservableList.get(j).getMonth().equals(monthsObservableList.get(i).toString())) {
                    sum = sum + Long.parseLong(expenditureObservableList.get(j).getAmount());
                }
            }
            piechartData.add(new PieChart.Data(monthsObservableList.get(i).toString(), (double) sum));
        }
        monthlyPieChart.setData(piechartData);
        monthlyPieChart.setVisible(true);

    }

    public void categoricalTabClicked() {
        ObservableList<PieChart.Data> piechartData = FXCollections.observableArrayList();
        ObservableList<Expenditure> expenditureObservableList = new ExpenditureDAO().getAllExpendituresFromDb();
        ObservableList<ExpenditureType> expenditureTypeObservableList = new ExpenditureDAO().getExpenditureTypesList();
        for (int i = 0; i < expenditureTypeObservableList.size(); i++) {
            long sum = 0;
            for (int j = 0; j < expenditureObservableList.size(); j++) {
                if (expenditureObservableList.get(j).getActivityName().equals(expenditureTypeObservableList.get(i).getExpenditureName())) {
                    sum = sum + Long.parseLong(expenditureObservableList.get(j).getAmount());
                }
            }
            piechartData.add(new PieChart.Data(expenditureTypeObservableList.get(i).getExpenditureName(), (double) sum));
        }
        categoricalPieChart.setData(piechartData);
        categoricalPieChart.setVisible(true);

    }

    public void departmentalTabClicked() {
        ObservableList<PieChart.Data> piechartData = FXCollections.observableArrayList();
        ObservableList<Expenditure> expenditureObservableList = new ExpenditureDAO().getAllExpendituresFromDb();
        ObservableList<Department> departmentTypeObservableList = new DepartmentDAO().getDepartmentsList();
        for (int i = 0; i < departmentTypeObservableList.size(); i++) {
            long sum = 0;
            for (int j = 0; j < expenditureObservableList.size(); j++) {
                if (expenditureObservableList.get(j).getDepartmentName().equals(departmentTypeObservableList.get(i).getDepartmentName())) {
                    sum = sum + Long.parseLong(expenditureObservableList.get(j).getAmount());
                }
            }
            piechartData.add(new PieChart.Data(departmentTypeObservableList.get(i).getDepartmentName(), (double) sum));
        }
        departmentalPieChart.setData(piechartData);
        departmentalPieChart.setVisible(true);

    }
}

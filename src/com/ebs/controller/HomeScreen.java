package com.ebs.controller;

import com.ebs.dao.*;
import com.ebs.model.*;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class HomeScreen implements Initializable {

    public ImageView ebs_icon;
    public StackPane upperStackPane;
    public Rectangle upperMessageRectangle;
    public RadioButton radioButtonOne;
    public RadioButton radioButtonTwo;
    public RadioButton radioButtonThree;
    public RadioButton radioButtonFour;
    public RadioButton radioButtonFive;
    public Label upperRectangleLabel;
    public Label lowerRectangleLabel;
    public TableView expenditureTableView;
    public TableColumn expenditureColumnTwo;
    public TableColumn expenditureColumnOne;
    public TableColumn revenueColumnTwo;
    public TableColumn revenueColumnOne;
    public TableView revenueTableView;
    public ImageView expenditureRightButton;
    public ImageView expenditureLeftButton;
    public Label expenditureSlider;
    public ImageView revenueRightButton;
    public ImageView revenueLeftButton;
    public Label revenueSlider;
    public ComboBox addRevenueTypeComboBox;
    public ComboBox addRevenueMonthComboBox;
    public ComboBox addExpenditureTypeComboBox;
    public ComboBox addExpenditureMonthComboBox;
    public ComboBox addExpenditureDepartmentComboBox;
    public TextField addRevenueTextField;
    public TextField addExpenditureTextField;
    public Button addRevenueButton;
    public Button deleteRevenueButton;
    public Button addExpenditureButton;
    public Button deleteExpenditureButton;
    public ToggleButton totalRevenueToggleButton;
    public ToggleButton totalExpenditureToggleButton;
    public ToggleButton totalRevenueMinusExpenditureToggleButton;
    public static ObservableList<RevenueType> revenueTypeObservableList;
    public static ObservableList<String> monthObservaleList;
    public static ObservableList<ExpenditureType> expenditureTypeObservableList;
    public static ObservableList<Department> departmentObservableList;
    public VBox categoricalExpenditureVbox;
    public VBox departmentalExpenditureVbox;
    public VBox monthlyExpenditureVbox;
    public VBox categoricalRevenueVbox;
    public VBox departmentalRevenueVbox;
    public VBox monthlyRevenueVbox;
    private Expenditure expenditure;


    private ToggleGroup toggleGroup;
    private String[] upperTextArray;
    private String[] lowerTextArray;
    private ObservableList<Revenue> revenueObservaleList;
    private ObservableList<Revenue> workingRevenueObservaleList;
    private ObservableList<Expenditure> expenditureObservableList;
    private ObservableList<Expenditure> workingExpenditureObservableList;
    private int revenueSliderIndex = 0;
    private int sliderIndex = 0;
    private String[] expenditureLabelContent = new String[]{"Monthly", "Departmental", "Categorical"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAccessLevel();

        upperTextArray = new String[]{"Welcome", "Filtered Budget", "Total Revenue and Expense", "Budget Pie Chart on Right", "Add and Delete"};
        lowerTextArray = new String[]{"E-Budgetting System let's you plan and handle your budget for the year.", "View the budget of the Institute filtered by Month,Department and Category.", "Checkout the Total Revenue received and the total Expense occured.", "Find the details of every Activity in the form of Pie Charts.", "Add and Delete Revenues and Expenses Dynamically."};

        addRadioButtonsToToggleGroup();
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> setTheNewToggleMessage(oldValue, newValue));

        addRevenueTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                addRevenueTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (addRevenueTextField.getText().length() >= 9)
                addRevenueTextField.setText(oldValue);
        });
        addExpenditureTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                addExpenditureTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (addExpenditureTextField.getText().length() >= 9)
                addExpenditureTextField.setText(oldValue);
        });

        populateRevenueTypeComboBox();
        populateMonthComboBoxes();
        populateExpenditureTypeComboBox();
        populateExpenditureDepartmentComboBox();
        populateRevenueTable();
        populateExpenditureTable();
        setTotalRevenueAndExpenditure();

        revenueTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (revenueTableView.getSelectionModel().getSelectedCells().size() > 0)
                deleteRevenueButton.disableProperty().setValue(false);
            else deleteRevenueButton.disableProperty().setValue(true);
        });

        expenditureTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (expenditureTableView.getSelectionModel().getSelectedCells().size() > 0)
                deleteExpenditureButton.disableProperty().setValue(false);
            else deleteExpenditureButton.disableProperty().setValue(true);

        });

    }

    private void getAccessLevel() {
        Preferences preferences = Preferences.userRoot().node(SignIn.PREFERENCES_NODE);
        String accessLevel = preferences.get("access_level", "None");
        switch (accessLevel) {
            case "None":

                break;
            case "ADMIN":

                break;
            case "DIRECTOR":

                break;
            case "PROCTOR":

                break;
            case "REGISTRAR":
                getRegistrarHomeScreen();

                break;
            default:
        }

    }

    private void populateRevenueTypeComboBox() {
        revenueTypeObservableList = new RevenueDAO().getRevenueTypesList();
        for (int i = 0; i < revenueTypeObservableList.size(); i++)
            addRevenueTypeComboBox.getItems().add(revenueTypeObservableList.get(i).getRevenueName());
    }

    private void populateMonthComboBoxes() {
        monthObservaleList = FXCollections.observableArrayList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        addRevenueMonthComboBox.setItems(monthObservaleList);
        addExpenditureMonthComboBox.setItems(monthObservaleList);
    }

    private void populateExpenditureTypeComboBox() {
        expenditureTypeObservableList = new ExpenditureDAO().getExpenditureTypesList();
        for (int i = 0; i < expenditureTypeObservableList.size(); i++)
            addExpenditureTypeComboBox.getItems().add(expenditureTypeObservableList.get(i).getExpenditureName());
    }

    private void populateExpenditureDepartmentComboBox() {
        departmentObservableList = new DepartmentDAO().getDepartmentsList();
        for (int i = 0; i < departmentObservableList.size(); i++)
            addExpenditureDepartmentComboBox.getItems().add(departmentObservableList.get(i).getDepartmentName());
    }

    private void populateRevenueTable() {
        revenueTableView.setEditable(true);
        revenueObservaleList = new RevenueDAO().getAllRevenuesFromDb();
        workingRevenueObservaleList = new RevenueDAO().getAllRevenuesFromDb();
        ;
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnOne.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent event) {

            }
        });
        revenueColumnTwo.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent event) {
            }
        });
        revenueTableView.setItems(workingRevenueObservaleList);
    }


    private void populateExpenditureTable() {
        expenditureTableView.setEditable(true);
        expenditureObservableList = new ExpenditureDAO().getAllExpendituresFromDb();
        workingExpenditureObservableList = new ExpenditureDAO().getAllExpendituresFromDb();
        System.out.println(workingExpenditureObservableList.size());
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnOne.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent event) {

            }
        });
        expenditureColumnTwo.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent event) {

            }
        });
        expenditureTableView.setItems(workingExpenditureObservableList);
    }

    private void setTotalRevenueAndExpenditure() {
        int sum = 0;
        for (int i = 0; i < expenditureObservableList.size(); i++)
            sum += Integer.parseInt(expenditureObservableList.get(i).getAmount());
        totalExpenditureToggleButton.textProperty().set(String.valueOf(sum));
        sum = 0;
        for (int i = 0; i < revenueObservaleList.size(); i++)
            sum += Integer.parseInt(revenueObservaleList.get(i).getAmount());
        totalRevenueToggleButton.textProperty().set(String.valueOf(sum));
        if (revenueObservaleList.size() < 1)
            totalRevenueToggleButton.setText("0");
        if (expenditureObservableList.size() < 1)
            totalExpenditureToggleButton.setText("0");
        totalRevenueMinusExpenditureToggleButton.setText(String.valueOf(Integer.parseInt(totalRevenueToggleButton.getText()) - Integer.parseInt(totalExpenditureToggleButton.getText())));
    }

    private void setTheNewToggleMessage(Toggle oldValue, Toggle newValue) {
        RadioButton radioButton = (RadioButton) newValue;
        fadeOutEverything();
        switch (radioButton.getId()) {
            case "radioButtonOne":
                setTextToLabels(upperTextArray[0], lowerTextArray[0]);
                break;
            case "radioButtonTwo":
                setTextToLabels(upperTextArray[1], lowerTextArray[1]);
                break;
            case "radioButtonThree":
                setTextToLabels(upperTextArray[2], lowerTextArray[2]);
                break;
            case "radioButtonFour":
                setTextToLabels(upperTextArray[3], lowerTextArray[3]);
                break;
            case "radioButtonFive":
                setTextToLabels(upperTextArray[4], lowerTextArray[4]);
                break;
        }
        fadeInEverything();
    }

    private void clearAddRevenueSelections() {
        addRevenueTextField.clear();
        addRevenueTypeComboBox.getSelectionModel().clearSelection();
        addRevenueMonthComboBox.getSelectionModel().clearSelection();
    }

    private void addRadioButtonsToToggleGroup() {
        toggleGroup = new ToggleGroup();
        radioButtonOne.setToggleGroup(toggleGroup);
        radioButtonTwo.setToggleGroup(toggleGroup);
        radioButtonThree.setToggleGroup(toggleGroup);
        radioButtonFour.setToggleGroup(toggleGroup);
        radioButtonFive.setToggleGroup(toggleGroup);
        radioButtonOne.setSelected(true);
    }

    private void fadeOutEverything() {
        fadeOut(upperMessageRectangle);
        fadeOut(upperRectangleLabel);
        fadeOut(lowerRectangleLabel);
    }

    private void setTextToLabels(String upperText, String lowerText) {
        upperRectangleLabel.setText(upperText);
        lowerRectangleLabel.setText(lowerText);
    }

    private void fadeOut(Rectangle rectangle) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(rectangle);
        fadeTransition.setDuration(Duration.millis(500));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
    }

    private void fadeOut(Label label) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(label);
        fadeTransition.setDuration(Duration.millis(500));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
    }

    private void fadeInEverything() {
        fadeIn(upperMessageRectangle);
        fadeIn(upperRectangleLabel);
        fadeIn(lowerRectangleLabel);
    }

    private void fadeIn(Rectangle rectangle) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(rectangle);
        fadeTransition.setDuration(Duration.millis(500));
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    private void fadeIn(Label label) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(label);
        fadeTransition.setDuration(Duration.millis(500));
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    public void signOut() {
        clearAccessLevel();
        moveToSignInScreen();
    }

    private void moveToSignInScreen() {
        try {
            Parent signInScreenParent = FXMLLoader.load(getClass().getClassLoader().getResource("resources/sign_in.fxml"));
            Scene signInScreenScene = new Scene(signInScreenParent, 1366, 740);
            Stage stage = (Stage) upperStackPane.getScene().getWindow();
            stage.setScene(signInScreenScene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearAccessLevel() {
        Preferences preferences = Preferences.userRoot().node(SignIn.PREFERENCES_NODE);
        preferences.put("access_level", "None");
    }

    public void expenditureRightButtonClicked() {
        fadeOut(expenditureSlider);
        sliderIndex = (sliderIndex + 1) % 3;
        expenditureSlider.setText(expenditureLabelContent[sliderIndex]);
        switch (sliderIndex) {
            case 0:
                onCategoricalOverallExpenditureButtonClicked();
                monthlyExpenditureVbox.setVisible(true);
                departmentalExpenditureVbox.setVisible(false);
                categoricalExpenditureVbox.setVisible(false);
                break;

            case 1:
                onCategoricalOverallExpenditureButtonClicked();
                departmentalExpenditureVbox.setVisible(true);
                monthlyExpenditureVbox.setVisible(false);
                categoricalExpenditureVbox.setVisible(false);
                break;

            case 2:
                onCategoricalOverallExpenditureButtonClicked();
                categoricalExpenditureVbox.setVisible(true);
                departmentalExpenditureVbox.setVisible(false);
                monthlyExpenditureVbox.setVisible(false);
                break;
        }
        fadeIn(expenditureSlider);

    }

    public void expenditureLeftButtonClicked() {
        fadeOut(expenditureSlider);
        if (sliderIndex == 0)
            sliderIndex = 2;
        else
            sliderIndex = (sliderIndex - 1) % 3;
        expenditureSlider.setText(expenditureLabelContent[sliderIndex]);
        switch (sliderIndex) {
            case 0:
                onCategoricalOverallExpenditureButtonClicked();
                monthlyExpenditureVbox.setVisible(true);
                departmentalExpenditureVbox.setVisible(false);
                categoricalExpenditureVbox.setVisible(false);
                break;

            case 1:
                onCategoricalOverallExpenditureButtonClicked();
                departmentalExpenditureVbox.setVisible(true);
                monthlyExpenditureVbox.setVisible(false);
                categoricalExpenditureVbox.setVisible(false);
                break;

            case 2:
                onCategoricalOverallExpenditureButtonClicked();
                categoricalExpenditureVbox.setVisible(true);
                departmentalExpenditureVbox.setVisible(false);
                monthlyExpenditureVbox.setVisible(false);
                break;
        }


        fadeIn(expenditureSlider);
    }


    public void revenueRightButtonClicked() {

        fadeOut(revenueSlider);
        revenueSliderIndex = (revenueSliderIndex + 1) % 3;
        revenueSlider.setText(expenditureLabelContent[revenueSliderIndex]);
        switch (revenueSliderIndex) {
            case 0:
                monthlyRevenueVbox.setVisible(true);
                departmentalRevenueVbox.setVisible(false);
                categoricalRevenueVbox.setVisible(false);
                break;

            case 1:
                departmentalRevenueVbox.setVisible(true);
                monthlyRevenueVbox.setVisible(false);
                categoricalRevenueVbox.setVisible(false);
                break;

            case 2:
                categoricalRevenueVbox.setVisible(true);
                departmentalRevenueVbox.setVisible(false);
                monthlyRevenueVbox.setVisible(false);
                break;

        }

        fadeIn(revenueSlider);

    }

    public void revenueLeftButtonClicked() {
        fadeOut(revenueSlider);
        if (revenueSliderIndex == 0) {
            revenueSliderIndex = 2;


        } else revenueSliderIndex = (revenueSliderIndex - 1) % 3;
        revenueSlider.setText(expenditureLabelContent[revenueSliderIndex]);
        switch (revenueSliderIndex) {
            case 0:
                monthlyRevenueVbox.setVisible(true);
                departmentalRevenueVbox.setVisible(false);
                categoricalRevenueVbox.setVisible(false);
                break;

            case 1:
                departmentalRevenueVbox.setVisible(true);
                monthlyRevenueVbox.setVisible(false);
                categoricalRevenueVbox.setVisible(false);
                break;

            case 2:
                categoricalRevenueVbox.setVisible(true);
                departmentalRevenueVbox.setVisible(false);
                monthlyRevenueVbox.setVisible(false);
                break;

        }
        fadeIn(revenueSlider);
    }

    public void revenueAddButtonClicked() {
        if (addRevenueTextField.getText().matches(""))
            return;
        if (addRevenueMonthComboBox.getSelectionModel().isEmpty())
            return;
        if (addRevenueTypeComboBox.getSelectionModel().isEmpty())
            return;
        if(Integer.parseInt(addRevenueTextField.getText()) < 1)
            return;
        int id = 0;
        if (revenueObservaleList.size() > 0) {
            id = revenueObservaleList.get(revenueObservaleList.size() - 1).getRevenueId() + 1;
        }
        Revenue revenue = new Revenue(id, addRevenueTypeComboBox.getSelectionModel().getSelectedItem().toString(), addRevenueTextField.getText(), addRevenueMonthComboBox.getSelectionModel().getSelectedItem().toString());
        if (new RevenueDAO().addRevenueToDb(revenue)) {
            revenueObservaleList.add(revenue);
            workingRevenueObservaleList.add(revenue);
            setTotalRevenueAndExpenditure();
            clearAddRevenueSelections();
        }
    }

    public void revenueDeleteButtonClicked() {
        Revenue revenue = (Revenue) revenueTableView.getSelectionModel().getSelectedItem();
        if (new RevenueDAO().deleteRevenue(revenue.getRevenueId())) {
            revenueObservaleList.remove(revenue);
            workingRevenueObservaleList.remove(revenue);
            setTotalRevenueAndExpenditure();
        }
    }

    public void expenditureAddButtonClicked() {
        if (addExpenditureTextField.getText().matches("") || addExpenditureDepartmentComboBox.getSelectionModel().isEmpty() || addExpenditureMonthComboBox.getSelectionModel().isEmpty() || addExpenditureTypeComboBox.getSelectionModel().isEmpty() || Integer.parseInt(addExpenditureTextField.getText()) < 1)
            return;
        int id = 0;
        if (expenditureObservableList.size() > 0)
            id = expenditureObservableList.get(expenditureObservableList.size() - 1).getExpenditureId() + 1;
        Expenditure expenditure = new Expenditure(id, addExpenditureDepartmentComboBox.getSelectionModel().getSelectedItem().toString(), addExpenditureMonthComboBox.getSelectionModel().getSelectedItem().toString(), addExpenditureTypeComboBox.getSelectionModel().getSelectedItem().toString(), addExpenditureTextField.getText().toString());
        if (new ExpenditureDAO().addExpenditureToDb(expenditure)) {
            expenditureObservableList.add(expenditure);
            workingExpenditureObservableList.add(expenditure);
            setTotalRevenueAndExpenditure();
            clearAddExpenditureSelections();
        }
    }

    private void clearAddExpenditureSelections() {
        addExpenditureTextField.clear();
        addExpenditureDepartmentComboBox.getSelectionModel().clearSelection();
        addExpenditureMonthComboBox.getSelectionModel().clearSelection();
        addExpenditureTypeComboBox.getSelectionModel().clearSelection();
    }

    public void expenditureDeleteButtonClicked() {
        expenditure = (Expenditure) expenditureTableView.getSelectionModel().getSelectedItem();
        if (new ExpenditureDAO().deleteExpenditure(expenditure.getExpenditureId())) {
            workingExpenditureObservableList.remove(expenditure);
            expenditureObservableList.remove(expenditure);
            setTotalRevenueAndExpenditure();
        }
    }

    public void onExpenditureJanuaryButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getJanuaryExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);
    }

    public void onExpenditureFebruaryButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getFebruaryExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);
    }

    public void onExpenditureMarchButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getMarchExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);
    }

    public void onExpenditureAprilButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getAprilExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);
    }


    public void onExpenditureMayButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getMayExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);
    }

    public void onExpenditureJuneButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getJuneExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);
    }

    public void onExpenditureJulyButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getJulyExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);
    }

    public void onExpenditureAugustButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getAugustExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);
    }

    public void onExpenditureSeptemberButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getSeptemberExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);
    }

    public void onExpenditureOctoberButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getOctoberExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);
    }


    public void onExpenditureNovemberButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getNovemberExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);
    }


    public void onExpenditureDecemberButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getDecemberExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);
    }

    public void onExpenditureMonthlyOverallButtonClicked() {
        onCategoricalOverallExpenditureButtonClicked();
    }


    public void onEngineeringExpenditureButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getEngineeringExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);
    }

    public void onMedicalExpenditureButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getMedicalExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);
    }

    public void onArtsExpenditureButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getArtsExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());

        expenditureTableView.setItems(workingExpenditureObservableList);
    }

    public void onManagementExpenditureButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getManagementExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());

        expenditureTableView.setItems(workingExpenditureObservableList);
    }

    public void onCommerceExpenditureButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getCommerceExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());

        expenditureTableView.setItems(workingExpenditureObservableList);

    }

    public void onCollegeAdministrationExpenditureButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getAdministrationExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);
    }

    public void onCcpdExpenditureButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getCcpdExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);

    }

    public void onOverallDepartmentExpenditureButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getAllExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);
    }

    public void onDebtChargesExpenditureButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getDebtChargesExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);

    }

    public void onFacultyExpenditureButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getFacultySalaryExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);


    }

    public void onInfrastructureExpenditureButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getInfrastructureExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);


    }

    public void onEventExpenditureButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getEventExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);

    }

    public void onArtLaboratoryExpenditureButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getArtlaboratoryExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);

    }

    public void onPlacementDriveExpenditureButtonClicked() {

        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getPlacementDriveExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);

    }

    public void onMiscellaneousExpenditureButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getMiscellaneousExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);


    }

    public void onTransportationExpenditureButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getTransportationExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);

    }

    public void onStudentDevelopmentExpenditureButtonClicked() {

        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getStudentDevelopmentExpendituresFromDb();
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);

    }

    public void onCategoricalOverallExpenditureButtonClicked() {
        expenditureTableView.setEditable(true);
        workingExpenditureObservableList = new ExpenditureDAO().getOverallDepartmentExpendituresFromDb();
        // workingExpenditureObservableList = expenditureObservableList;
        expenditureColumnOne.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("activityName"));
        expenditureColumnTwo.setCellValueFactory(new PropertyValueFactory<Expenditure, String>("amount"));
        expenditureColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        expenditureTableView.setItems(workingExpenditureObservableList);

    }


    public void onJanuaryRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        revenueObservaleList = new RevenueDAO().getJanuaryRevenuesFromDb();
        //   workingRevenueObservaleList = workingRevenueObservaleList;
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(revenueObservaleList);

    }

    public void onFebruaryRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getFebruaryRevenuesFromDb();
        // revenueObservaleList = revenueObservaleList;
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onMarchRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getMarchRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onAprilRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getAprilRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onMayRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getMayRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onJuneRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getJuneRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onJulyRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getJulyRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onAugustRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getAugustRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onSeptemberRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getSeptemberRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onOctoberRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getOctoberRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onNovemberRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getNovemberRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onDecemberRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getDecemberRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onEngineeringRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getEngineeringRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);


    }

    public void onMedicalRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getMedicalRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);


    }

    public void onArtsRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getArtsRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onCommerceRevenuebuttonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getCommerceRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onManagemnetRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getManagementRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onCollegeAdministrationRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getCollegeAdministrationRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onCcpdRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getCcpdRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onDepartmentalOverallRevenuebuttonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getAllRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);

    }

    public void onFeesRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getFeesRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);
    }

    public void onDonationRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getDonationRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);
    }

    public void onGovernmentGrantsRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getGovernmentGrantsRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);
    }

    public void onResearchSponsorRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getResearchSponsorRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);
    }

    public void onOtherIncomeRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getOtherIncomeRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);
    }

    public void onCategoricalOverallRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getAllRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);
    }

    public void onMonthlyOverallRevenueButtonClicked() {
        revenueTableView.setEditable(true);
        workingRevenueObservaleList = new RevenueDAO().getAllRevenuesFromDb();
        revenueColumnOne.setCellValueFactory(new PropertyValueFactory<Revenue, String>("type"));
        revenueColumnTwo.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        revenueColumnOne.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueColumnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        revenueTableView.setItems(workingRevenueObservaleList);
    }


    public void onCreditsButtonClicked() {
        try {
            Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("resources/credits.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.alwaysOnTopProperty();
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void openPieChart() {
        try {
            Parent pieChart = FXMLLoader.load(getClass().getClassLoader().getResource("resources/pie_chart.fxml"));
            Scene pieChartScene = new Scene(pieChart);
            Stage stage = new Stage();
            stage.setScene(pieChartScene);
            stage.setResizable(false);
            stage.alwaysOnTopProperty();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {

        }
    }

    private void getRegistrarHomeScreen(){
        addExpenditureButton.setDisable(true);
        deleteExpenditureButton.setDisable(true);
        expenditureTableView.getSelectionModel().getSelectedCells().addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                expenditureTableView.getSelectionModel().clearSelection();
            }
        });

    }
}
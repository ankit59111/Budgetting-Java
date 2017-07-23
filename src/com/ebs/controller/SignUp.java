package com.ebs.controller;

import com.ebs.dao.UserDAO;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

/**
 * Created by Ankit on 7/2/2017.
 */
public class SignUp implements Initializable {
    public ComboBox accessLevel;
    public TextField emailIdTextField;
    public PasswordField passwordField;
    public BorderPane signUpRootPane;
    public Label dublicateLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //signUpRootPane.setOpacity(0);
        makeFadeIn();
        choiceBoxItems();
        emailIdTextField.textProperty().addListener((observable, oldValue, newValue) ->{
            if(emailIdTextField.getText().length() > 20)
                emailIdTextField.setText(oldValue);
        });
        passwordField.textProperty().addListener((observable, oldValue, newValue) ->{
            if(passwordField.getText().length() > 15)
                passwordField.setText(oldValue);
        });
    }

    private void choiceBoxItems() {
        ObservableList<String> accessLevelList = FXCollections.observableArrayList("Admin", "Director", "Proctor", "Registrar");
        accessLevel.setPromptText("Choose your Level ");
        accessLevel.setItems(accessLevelList);
    }

    public void signUpButtonClicked() {
        if (emailIdTextField.getText().matches("") || passwordField.getText().matches("") || accessLevel.getSelectionModel().isEmpty()) {
            if (emailIdTextField.getText().matches("")) {
                emailIdEmpty();
            }
            if (passwordField.getText().matches("")) {
                passwordFieldEmpty();
            }
            if (accessLevel.getSelectionModel().isEmpty()) {
                comboBoxIsEmpty();
            }
        } else storeNewUser();

    }

    private void comboBoxIsEmpty() {
        System.out.println("ComboBox is Empty");
    }

    private void emailIdEmpty() {
        System.out.println("Email ID is Empty");
    }

    private void passwordFieldEmpty() {
        System.out.println("Password field is Empty");
    }

    private void storeUserAccessLevel(String accessLevel) {
        Preferences preferences = Preferences.userRoot().node(SignIn.PREFERENCES_NODE);
        preferences.put("access_level", accessLevel.toString());
    }

    private void storeNewUser() {
        String message = new UserDAO().signUpUser(emailIdTextField.getText().toString(), passwordField.getText().toString(), accessLevel.getSelectionModel().getSelectedItem().toString());
        if (message.equals("Data Stored")) {
            storeUserAccessLevel(accessLevel.getSelectionModel().getSelectedItem().toString());
            moveOn();
        } else if (message.equals("Data Not Stored")) {
            System.out.println("Data Not Stored");
        } else if (message.equals("Duplicate Entry")) {
            duplicateEntry();
        } else if (message.equals("Data Too Long")) {
            dataTooLong();
        } else {
            System.out.println("Unknown Error");
        }
    }

    private void moveOn() {
        try {
            Parent homeScreenParent = FXMLLoader.load(getClass().getClassLoader().getResource("resources/home_screen.fxml"));
            Scene scene = new Scene(homeScreenParent, 1366, 740);
            Stage stage = (Stage) emailIdTextField.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void duplicateEntry(){
        dublicateLabel.setText("USERNAME ALREADY EXIST !");
        dublicateLabel.setStyle("");
        emailIdTextField.setText("");
        passwordField.setText("");

    }

    private void dataTooLong(){
        dublicateLabel.setText("DATA TOO LONG !                 ");
        emailIdTextField.setText("");
        passwordField.setText("");
    }



    private void makeFadeIn() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(100));
        fadeTransition.setNode(signUpRootPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }


    public void goBackToSignIn() {
        try {
            Parent signInScreenParent = FXMLLoader.load(getClass().getClassLoader().getResource("resources/sign_in.fxml"));
            Scene signInScreenScene = new Scene(signInScreenParent, 1366, 740);
            Stage stage = (Stage) emailIdTextField.getScene().getWindow();
            stage.setScene(signInScreenScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

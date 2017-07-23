package com.ebs.controller;

import com.ebs.dao.UserDAO;
import com.ebs.factory.DbFactory;
import com.ebs.model.AccessLevel;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.prefs.Preferences;

/**
 * Created by gaurav on 30/06/17.
 */
public class SignIn extends Application {

    public static final String PREFERENCES_NODE = "ebs_preference_node";

    public HBox upperHBox;
    public TextField usernameTextField;
    public PasswordField passwordField;
    public Button signInButton;
    public ImageView passwordExclamationMark;
    public ImageView usernameExclamationMark;
    public BorderPane borderPaneLayout;
    public static String accessLevel = "None";

    private Scene signInScene;
    private Scene homeScreenScene;

    private static Stage primaryStage;

    private void setPrimaryStage(Stage stage) {
        SignIn.primaryStage = stage;
    }

    public static Stage getPrimaryStage() {
        return SignIn.primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        setPrimaryStage(primaryStage);
        DbFactory.setUpMysqlConnection();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/sign_in.fxml"));
        signInScene = new Scene(root);
        primaryStage.setScene(signInScene);
        primaryStage.setTitle("E-Budgetting System");
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> DbFactory.closeMySqlConnection());
        checkIfAlreadyLoggedIn();
    }

    public void signInButtonClicked() {
        if (usernameTextField.getText().matches("") || passwordField.getText().matches("")) {
            if (usernameTextField.getText().matches(""))
                usernameEmpty();
            if (passwordField.getText().matches(""))
                passwordEmpty();
        } else {
            signInUser(usernameTextField.getText().toString(), passwordField.getText().toString());
        }
    }

    private void signInUser(String username, String password) {
        AccessLevel userAccessLevel = new UserDAO().signIn(username, password);
        if (userAccessLevel == null)
            invalidUsernameOrPassword();
        else
            validUsernameOrPassword(userAccessLevel);
    }

    private void invalidUsernameOrPassword() {
        passwordEmpty();
        usernameEmpty();
    }

    private void validUsernameOrPassword(AccessLevel accessLevel) {
        clearUsernameAndPasswordFields();
        storeUserAccessLevel(accessLevel.toString());
        moveOn();
    }

    private void moveOn() {
        try {
            Parent homeScreenParent = FXMLLoader.load(getClass().getClassLoader().getResource("resources/home_screen.fxml"));
            homeScreenScene = new Scene(homeScreenParent, 1366, 740);
            //Stage stage = (Stage) usernameTextField.getScene().getWindow();
            Stage stage = getPrimaryStage();
            stage.setScene(homeScreenScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void signUpClicked() {
        makeFadeOut();
    }

    private void goToSignUp() {
        try {
            Parent signUpScreenParent = FXMLLoader.load(getClass().getClassLoader().getResource("resources/sign_up.fxml"));
            Scene signUpScreenScene = new Scene(signUpScreenParent, 1366, 740);
            Stage stage = (Stage) signInButton.getScene().getWindow();
            stage.setScene(signUpScreenScene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void usernameEmpty() {
        usernameTextField.setText("");
        usernameTextField.setStyle("-fx-border-color: red ; -fx-border-width: 1px ; -fx-border-radius: 5px ;");
        usernameExclamationMark.setVisible(true);
    }

    private void passwordEmpty() {
        passwordField.setText("");
        passwordField.setStyle("-fx-border-color: red ; -fx-border-width: 1px ; -fx-border-radius: 5px ;");
        passwordExclamationMark.setVisible(true);
    }

    private void clearUsernameAndPasswordFields() {
        usernameTextField.setText("");
        usernameTextField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ; -fx-border-radius: 5px ;");
        usernameExclamationMark.setVisible(false);
        passwordField.setText("");
        passwordField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ; -fx-border-radius: 5px ;");
        passwordExclamationMark.setVisible(false);
    }

    private void storeUserAccessLevel(String accessLevel) {
        Preferences preferences = Preferences.userRoot().node(PREFERENCES_NODE);
        preferences.put("access_level", accessLevel.toString());
    }

    public static String getAccessLevel() {
        Preferences preferences = Preferences.userRoot().node(PREFERENCES_NODE);
        return preferences.get("access_level", "None");
    }

    private void checkIfAlreadyLoggedIn() {
        accessLevel = getAccessLevel();
        if (accessLevel.equals("None")) {
            return;
        } else {
            moveOn();
        }
    }

    private void makeFadeOut() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(100));
        fadeTransition.setNode(borderPaneLayout);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(e -> goToSignUp());
        fadeTransition.play();
    }
}
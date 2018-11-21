package JavaFX;

import Database.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import javafx.scene.layout.BorderPane;

public class SignUpPageController {

    @FXML
    private AnchorPane signUpPage;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField cityField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField password;

    @FXML
    public void sendData(ActionEvent event) throws IOException{
        Main accessToMain = new Main();

        String firstnameIN = firstName.getText();
        String lastnameIN = lastName.getText();
        String cityIN = cityField.getText();
        String ageIN = ageField.getText();
        String email = emailField.getText();
        accessToMain.setEmailIN(email);
        String passwordEntered = password.getText();

        DatabaseMethodsClass database = new DatabaseMethodsClass();
        try {
            database.addNewUser(firstnameIN,lastnameIN,cityIN,ageIN,email,passwordEntered);
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadMainMenu();
    }

    @FXML
    private void loadMainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/mainMenu.fxml"));
        BorderPane pane = loader.load();
        signUpPage.getChildren().setAll(pane);
    }

    @FXML
    private void goToLoginPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/sample.fxml"));
        AnchorPane pane = loader.load();
        signUpPage.getChildren().setAll(pane);
    }
}
package JavaFX;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import Database.*;

public class SignUpPageController {


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
    private Button sendDataID;

    @FXML
    public void sendData(ActionEvent event){
        Controller access = new Controller();

        String firstnameIN = firstName.getText();
        String lastnameIN = lastName.getText();
        String cityIN = cityField.getText();
        String ageIN = ageField.getText();
        String email = emailField.getText();
        access.setEmailIN(email);
        String passwordEntered = password.getText();
        access.setPasswordIN(passwordEntered);

        DatabaseMethodsClass database = new DatabaseMethodsClass();
        try {
            database.addNewUser(firstnameIN,lastnameIN,cityIN,ageIN,email,passwordEntered);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*} catch (){}*/

    }

}
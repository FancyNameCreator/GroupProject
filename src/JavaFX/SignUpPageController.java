package JavaFX;

import Database.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
    private DatePicker datePicker;

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
        String ageIN = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String email = emailField.getText();
        accessToMain.setEmailIN(email);
        String passwordEntered = password.getText();

        DatabaseMethodsClass database = new DatabaseMethodsClass();
        try {
            addNewUser(firstnameIN,lastnameIN,cityIN,ageIN,email,passwordEntered);
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

    public static boolean addNewUser(String firstName, String lastName, String city,String age,String email,String password){
       try {
            String sql = "insert into users "
                    + "(first_name, last_name, email, password, city, DoB)"
                    + "values ('" + firstName + "','" + lastName + "','" + email + "','" + password + "','" + city + "','" + age + "')";

            // executing MySQL command that value is stored in sql variable
            Main.stmt.executeUpdate(sql);
            System.out.println("Data inserted!");
        } catch (SQLException e) {  // catch exception if occur
            e.printStackTrace();
        }
        return true;
    }

}
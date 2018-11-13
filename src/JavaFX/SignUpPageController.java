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
        String firstnameIN = firstName.getText();
        String lastnameIN = lastName.getText();
        String cityIN = cityField.getText();
        String ageIN = ageField.getText();
        String emailIN = emailField.getText();
        String passwordIN = password.getText();

            /*Statement statement = connection.createStatement();

            int status = statement.executeUpdate("Insert into users (first_name, last_name, city, age, email, password)" +
                    "values('" + firstname + "','" + lastname + "','" + city + "','" + age + "','" + email + "','" + password + "')");
            if (status > 0) {
                System.out.println("user registered");
            }
            */
        DatabaseMethodsClass database = new DatabaseMethodsClass();
        try {
            database.addNewUser(firstnameIN,lastnameIN,cityIN,ageIN,emailIN,passwordIN);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*} catch (){}*/

    }

}
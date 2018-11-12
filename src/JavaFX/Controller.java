package JavaFX;

import Database.LogInOrCreateUserClass;
import Database.MainClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.DriverManager;
import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class Controller {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private void loadSignup(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("signUpPage.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    public void validate(ActionEvent event) throws SQLException {
        LogInOrCreateUserClass login = new LogInOrCreateUserClass();

        String name = username.getText();
        String passw = password.getText();

        if (name.isEmpty()||passw.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("You need to fill in all the fields");
            alert.showAndWait();
        } else if(login.loginAndPasswordChecking(name,passw)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Successful login");
            alert.showAndWait();
        } else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("The information entered is incorrect");
            alert.showAndWait();
            username.setText("");
            password.setText("");
        }
    }
}

package JavaFX;

import Database.LogInOrCreateUserClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.sql.*;
import java.io.IOException;


public class Controller {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private void loadSignup(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/signUpPage.fxml"));
        AnchorPane pane = loader.load();
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    private String emailIN;
    private String passwordIN;

    public void setEmailIN(String emailIN) {
        this.emailIN = emailIN;
    }

    public void validate(ActionEvent event) throws IOException {
        LogInOrCreateUserClass login = new LogInOrCreateUserClass();

        emailIN = username.getText();
        passwordIN = password.getText();

        Main.setEmailIN(emailIN);

        if (emailIN.isEmpty()||passwordIN.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("You need to fill in all the fields");
            alert.showAndWait();
        } else if(login.loginAndPasswordChecking(emailIN,passwordIN)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Successful login");
            alert.showAndWait();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resources/mainMenu.fxml"));
            AnchorPane pane = loader.load();
            rootPane.getChildren().setAll(pane);
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

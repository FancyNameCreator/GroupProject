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
    String user="Juli";
    String pass="1234";

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
        LogInOrCreateUserClass logInOrCreateUserClass = new LogInOrCreateUserClass();
        Connection conn = DriverManager.getConnection("jdbc:mysql://35.228.89.148:3306/hangerDatabase", "root","PasswordOfGroup6P1Project");
        String sql="INSERT INTO USER VALUES('"+username.getText()+"')";
        Statement statement=conn.createStatement();
        statement.executeUpdate(sql);

        String name = username.getText();
        String passw = password.getText();
        if (name.isEmpty()||passw.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("You need to fill in all the fields");
            alert.showAndWait();
        } else if(name.equals(user) && passw.equals(pass)){
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

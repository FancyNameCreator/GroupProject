package JavaFX;

import Database.LogInOrCreateUserClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;


public class Controller {
    @FXML
    private BorderPane rootPane;

    @FXML
    private void loadSignup(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/signUpPage.fxml"));
        BorderPane pane = loader.load();
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

    public void validate() throws IOException {
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
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resources/mainMenu.fxml"));
            BorderPane pane = loader.load();
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

    @FXML
    private void actOnEnter(KeyEvent event){
        if(event.getCode() == KeyCode.ENTER){
            try {
                validate();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}

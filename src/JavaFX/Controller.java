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

/**
 * Class that controls logging in process (controller of sample.fxml)
 */
public class Controller {

    @FXML private BorderPane rootPane;

    @FXML private TextField username;
    @FXML private TextField password;

    //  called by clicking log in button, gets info from the users and checks if correct
    public void validate() throws IOException {
        LogInOrCreateUserClass login = new LogInOrCreateUserClass();

        //  get chars inserted in text fields
        String emailIN = username.getText();
        String passwordIN = password.getText();

        //  set email of current user
        Main.setEmailIN(emailIN);

        if (emailIN.isEmpty()||passwordIN.isEmpty()){           //  in case user hasn't field text fields
            Alert alert=new Alert(Alert.AlertType.ERROR);       //  show an alert
            alert.setHeaderText(null);
            alert.setContentText("You need to fill in all the fields");
            alert.showAndWait();
        } else if(login.loginAndPasswordChecking(emailIN,passwordIN)){      //  checking if data is correct
            FXMLLoader loader = new FXMLLoader();                           //  IF YES - Log in
            loader.setLocation(getClass().getResource("/resources/mainMenu.fxml"));
            BorderPane pane = loader.load();
            rootPane.getChildren().setAll(pane);
        } else {                                                    //  IF NOT - Show alert
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("The information entered is incorrect");
            alert.showAndWait();
            username.setText("");
            password.setText("");
        }
    }


    //  this method allows logging in also by clicking ENTER button
    @FXML
    private void actOnEnter(KeyEvent event){
        if(event.getCode() == KeyCode.ENTER){   //  checks whether key code that user clicked is same as this of enter
            try {                               //  ^ 'if key equals ENTER'
                validate();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    //  loads Sign Up Page, is called by clicking Sign up button
    @FXML
    private void loadSignup(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/signUpPage.fxml"));
        BorderPane pane = loader.load();
        rootPane.getChildren().setAll(pane);
    }
}

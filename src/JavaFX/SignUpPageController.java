package JavaFX;

import Database.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.layout.BorderPane;

public class SignUpPageController {

    @FXML
    private BorderPane signUpPage;

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

        String firstnameIN = firstName.getText();
        String lastnameIN = lastName.getText();
        String cityIN = cityField.getText();
        String ageIN = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate age = datePicker.getValue();
        String email = emailField.getText();
        Main.setEmailIN(email);
        String passwordEntered = password.getText();


            if(checking(firstnameIN,lastnameIN,cityIN,age,email,passwordEntered)) {
                try {
                    addNewUser(firstnameIN, lastnameIN, cityIN, ageIN, email, passwordEntered);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                loadMainMenu();
            }else{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/resources/signUpPage.fxml"));
                BorderPane pane = loader.load();
                signUpPage.getChildren().setAll(pane);
            }

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
        BorderPane pane = loader.load();
        signUpPage.getChildren().setAll(pane);
    }

    private static void addNewUser(String firstName, String lastName, String city,String age,String email,String password){
       try {
            String sql = "insert into users "
                    + "(first_name, last_name, email, password, city, DoB)"
                    + "values ('" + firstName + "','" + lastName + "','" + email + "','" + password + "','" + city + "','" + age + "')";

            // executing MySQL command that value is stored in sql variable
            Main.stmt.executeUpdate(sql);

           Alert alert=new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText(null);
           alert.setContentText("Data inserted");
           alert.showAndWait();

        } catch (SQLException e) {  // catch exception if occur
            e.printStackTrace();
        }
    }

    private boolean checking (String firstName, String lastName, String city, LocalDate DOB,String email,String password){

        LocalDate dateLimit = LocalDate.now();
        dateLimit = dateLimit.minusYears(16);

        if (firstName==null){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("First Name field is empty, enter sth!");
            alert.showAndWait();
            return false;
        }

        if (lastName==null){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Last Name field is empty, enter sth!");
            alert.showAndWait();
            return false;
        }

        if (city==null){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("City field is empty, enter sth!");
            alert.showAndWait();
            return false;
        }

       /*AGE*/
        if (DOB.isAfter(dateLimit)){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("You are to young!");
            alert.showAndWait();
            return false;
        }

        if (email==null){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Email field is empty, enter sth!");
            alert.showAndWait();
            return false;
        }

        if (emailIsRepeating(email))
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Email already exists in Database, insert new one");
            alert.showAndWait();
            return false;
        }

        if (password==null){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Password field is empty, enter sth!");
            alert.showAndWait();
            return false;
        }
    return true;
    }

    private boolean emailIsRepeating(String email){
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from users where email = '"+email+"'");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("id");
                if (ID != null)
                    return true;
            }

        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    return false;
    }

}
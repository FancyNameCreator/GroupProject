package JavaFX;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.layout.BorderPane;

/**
 * class controls signUpPage.fxml, including all the methods it regarding
 */
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
    private TextField emailField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private PasswordField password;


    //  method is called as request of sending data of a user, yet calls other methods to validate information
    @FXML
    public void sendData() throws IOException {

        String firstnameIN = firstName.getText();
        String lastnameIN = lastName.getText();
        String cityIN = cityField.getText();

        if (datePicker.getValue()==null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You forgot of filling your Date of BTH!");
            alert.showAndWait();
            return;
        }

        String ageIN = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate age = datePicker.getValue();
        String email = emailField.getText();
        Main.setEmailIN(email);
        String passwordEntered = password.getText();


        if (checking(firstnameIN, lastnameIN, cityIN, age, email, passwordEntered)) {
            try {
                addNewUser(firstnameIN, lastnameIN, cityIN, ageIN, email, passwordEntered);

            } catch (Exception e) {
                e.printStackTrace();
            }
            loadMainMenu();
        } else {
            /*FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resources/signUpPage.fxml"));
            BorderPane pane = loader.load();
            signUpPage.getChildren().setAll(pane);*/

        }
    }

    //  method inserts information of the new user to the database
    private static void addNewUser(String firstName, String lastName, String city, String age, String email, String password) {
        try {
            String sql = "insert into users "
                    + "(first_name, last_name, email, password, city, DoB)"
                    + "values ('" + firstName + "','" + lastName + "','" + email + "','" + password + "','" + city + "','" + age + "')";

            // executing MySQL command that value is stored in sql variable
            Main.stmt.executeUpdate(sql);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Data inserted");
            alert.showAndWait();

        } catch (SQLException e) {  // catch exception if occur
            e.printStackTrace();
        }
    }

    //  method checks if inserted data is correct and if the user filled all the fields
    private boolean checking(String firstName, String lastName, String city, LocalDate DOB, String email, String password) {

        LocalDate dateLimit = LocalDate.now();
        dateLimit = dateLimit.minusYears(16);

        if (firstName.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("First Name field is empty, enter sth!");
            alert.showAndWait();
            return false;
        }

        if (lastName.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Last Name field is empty, enter sth!");
            alert.showAndWait();
            return false;
        }

        if (city.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("City field is empty, enter sth!");
            alert.showAndWait();
            return false;
        }

        /*AGE*/
        if (DOB.isAfter(dateLimit)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("You are to young!");
            alert.showAndWait();
            return false;
        }

        if (email.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Email field is empty, enter sth!");
            alert.showAndWait();
            return false;
        }

        if (emailIsRepeating(email)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Email already exists in Database, insert new one");
            alert.showAndWait();
            return false;
        }

        if (password.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Password field is empty, enter sth!");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    //  method checks whether email is repeating in a database, if so it returns true, else false
    boolean emailIsRepeating(String email) {
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from users where email = '" + email + "'");

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

    //  method calls sendData method every time ENTER is a button clicked by a user
    @FXML
    private void actOnEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            try {
                sendData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    -----------------------------------------------------------------------------------------
    LOADERS METHODS - methods that load new scenes
    -----------------------------------------------------------------------------------------
     */
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

}
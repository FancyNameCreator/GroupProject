package JavaFX;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.sql.*;

public class ProfileController {


    @FXML
    private Button firstNameButton;
    @FXML
    private Button lastNameButton;
    @FXML
    private Button cityButton;
    @FXML
    private Button ageButton;
    @FXML
    private Button emailButton;
    @FXML
    private Button passwordButton;

    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordTextField;

    private boolean firstNameButtonClicked=false;
    private boolean lastNameButtonClicked=false;
    private boolean cityButtonClicked=false;
    private boolean ageButtonClicked=false;
    private boolean emailButtonClicked=false;
    private boolean passwordButtonClicked=false;


    private String firstName;
    private String lastName;
    private String city;
    private String age;
    private String email;
    private String password;


    private void startProfile(ActionEvent ae){
        unableToWrite();
        Controller access = new Controller();
        getData(access.getEmailIN());
        firstNameTextField.setText(firstName);
        lastNameTextField.setText(lastName);
        cityTextField.setText(city);
        ageTextField.setText(age);
        emailTextField.setText(email);
        passwordTextField.setText(password);

    }

    private void unableToWrite(){
        firstNameTextField.setEditable(false);
        lastNameTextField.setEditable(false);
        cityTextField.setEditable(false);
        ageTextField.setEditable(false);
        emailTextField.setEditable(false);
        passwordTextField.setEditable(false);
    }



    private void getData(String emailPassed){
        Controller access = new Controller();
        String emailRead = access.getEmailIN();

        try {
    /*
                // 1. Get a connection to the Database
                Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Connection established \n");
                // 2. Create a statement
                Statement myStatmnt = myConn.createStatement();
    */            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from users where email ='" + emailRead + "' ");

            // 4. Process the result set
            while (myResults.next()) {
                firstName = myResults.getString("first_name");
                lastName = myResults.getString("last_name");
                email = myResults.getString("email");
                city = myResults.getString("city");
                age = myResults.getString("age");
                password = myResults.getString("password");
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML
    private void updateFirstName(ActionEvent ae) {
        firstNameTextField.setEditable(true);
        firstNameButtonClicked = true;
    }

    @FXML
    private void updateLastName(ActionEvent ae){
        lastNameTextField.setEditable(true);
        lastNameButtonClicked = true;
    }

    @FXML
    private void updateCity(ActionEvent ae){
        cityTextField.setEditable(true);
        cityButtonClicked = true;
    }

    @FXML
    private void updateAge(ActionEvent ae){
        ageTextField.setEditable(true);
        ageButtonClicked = true;
    }

    @FXML
    private void updateEmail(ActionEvent ae){
        emailTextField.setEditable(true);
        emailButtonClicked= true;
    }

    @FXML
    private void updatePassword(ActionEvent ae){
        passwordTextField.setEditable(true);
        passwordButtonClicked = true;
    }

    @FXML
    private void submitUpdates(ActionEvent ae){
        Controller access = new Controller();
        String emailRead = access.getEmailIN();
        Main connection = new Main();
        Controller access1 = new Controller();
        String sql;
        unableToWrite();

        try {
            if (firstNameButtonClicked && !firstName.equals(firstNameTextField.getText())) {
                firstName = firstNameTextField.getText();
                sql = "update users set first_name = '" + firstName + "' where email ='" + emailRead + "'";
                connection.stmt.executeUpdate(sql);
            }

            if (lastNameButtonClicked && !lastName.equals(lastNameTextField.getText())){
                lastName = lastNameTextField.getText();
                sql = "update users set last_name = '" + lastName + "' where email ='" + emailRead + "'";
                connection.stmt.executeUpdate(sql);
            }

            if (cityButtonClicked && !city.equals(cityTextField.getText())){
                city = cityTextField.getText();
                sql = "update users set city = '" + city + "' where email ='" + emailRead + "'";
                connection.stmt.executeUpdate(sql);
            }

            if (ageButtonClicked && !age.equals(ageTextField.getText())){
                age = ageTextField.getText();
                /*dont remember column name*/ sql = "update users set age = '" + lastName + "' where email ='" + emailRead + "'";
                connection.stmt.executeUpdate(sql);
            }

            if (emailButtonClicked && !email.equals(emailTextField.getText())){
                email = emailTextField.getText();
                access1.setEmailIN(email);
                sql = "update users set email = '" + email + "' where email ='" + emailRead + "'";
                connection.stmt.executeUpdate(sql);
            }

            if (passwordButtonClicked && !password.equals(passwordTextField.getText())){
                password = passwordTextField.getText();
                sql = "update users set password = '" + password + "' where email ='" + emailRead + "'";
                connection.stmt.executeUpdate(sql);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
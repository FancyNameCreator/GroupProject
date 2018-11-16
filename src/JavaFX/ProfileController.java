package JavaFX;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.sql.*;
import java.util.Scanner;

public class ProfileController {

    final String DB_URL = "jdbc:mysql://35.228.89.148:3306/hangerDatabase";

    //  Database credentials
    final String USER = "root";
    final String PASS = "PasswordOfGroup6P1Project";

    @FXML private Button firstNameButton;
    @FXML private Button lastNameButton;
    @FXML private Button cityButton;
    @FXML private Button ageButton;
    @FXML private Button emailButton;
    @FXML private Button passwordButton;

    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField cityTextField;
    @FXML private TextField ageTextField;
    @FXML private TextField emailTextField;
    @FXML private TextField passwordTextField;


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

                // 1. Get a connection to the Database
                Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Connection established \n");

                // 2. Create a statement
                Statement myStatmnt = myConn.createStatement();

                // 3. Execute SQL query
                ResultSet myResults = myStatmnt.executeQuery("select * from users where email ='" + emailRead + "' ");

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

    public void updateFirstName(String email) {

        firstNameTextField.setEditable(true);


        Connection conn = null;
        Statement stmt = null;

        try {
            // create connection with DB
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // create statement in already existing connection
            stmt = conn.createStatement();

            // making String variable "sql" with MySQL command
            // inserting previously entered String to corresponding column in the Database
            // we use email as a determinant
            String sql = "update users set first_name = '" + firstName + "' where email ='" + email + "'";

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

package JavaFX;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.sql.Date;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * class that controls profile.fxml, including all method it regarding
 */
public class ProfileController {
    @FXML
    private BorderPane profilePane;

    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private DatePicker datePickerOfDoB;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordTextField;

    private boolean firstNameButtonClicked = false;
    private boolean lastNameButtonClicked = false;
    private boolean cityButtonClicked = false;
    private boolean ageButtonClicked = false;
    private boolean emailButtonClicked = false;
    private boolean passwordButtonClicked = false;


    private String firstName;
    private String lastName;
    private String city;
    private LocalDate age;
    private String email;
    private String password;
    private String bufor;

    @FXML
    private void initialize() {
        startrunning();
    }

    @FXML
    private void startrunning() {
        getData(Main.getEmailIN());
        unableToWrite();
        printText();
    }

    //  sets prompt text of a fields according to obtained information about the user
    private void printText() {
        firstNameTextField.setPromptText(firstName);
        lastNameTextField.setPromptText(lastName);
        cityTextField.setPromptText(city);
        datePickerOfDoB.setPromptText(age.toString());
        emailTextField.setPromptText(email);
        passwordTextField.setPromptText("(NOT VISIBLE)");
    }

    //  makes all fields uneditable, 'unclickable' and non-able to highlight
    private void unableToWrite() {
        firstNameTextField.setEditable(false);
        firstNameTextField.setMouseTransparent(true);
        firstNameTextField.setFocusTraversable(false);

        lastNameTextField.setEditable(false);
        lastNameTextField.setMouseTransparent(true);
        lastNameTextField.setFocusTraversable(false);

        cityTextField.setEditable(false);
        cityTextField.setMouseTransparent(true);
        cityTextField.setFocusTraversable(false);

        datePickerOfDoB.setEditable(false);
        datePickerOfDoB.setMouseTransparent(true);
        datePickerOfDoB.setFocusTraversable(false);

        emailTextField.setEditable(false);
        emailTextField.setMouseTransparent(true);
        emailTextField.setFocusTraversable(false);

        passwordTextField.setEditable(false);
        passwordTextField.setMouseTransparent(true);
        passwordTextField.setFocusTraversable(false);
    }

    //  gets data of a user from the DB
    private void getData(String emailPassed) {
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from users where email ='" + emailPassed + "' ");

            // 4. Process the result set
            while (myResults.next()) {
                firstName = (myResults.getString("first_name"));
                lastName = myResults.getString("last_name");
                email = myResults.getString("email");
                password = myResults.getString("password");
                city = myResults.getString("city");
                Date buf = myResults.getDate("DoB");
                age = buf.toLocalDate();

            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    //  called by clicking change button - makes field of first name fully editable
    @FXML
    private void updateFirstName() {
        firstNameTextField.setText(firstName);
        firstNameTextField.setMouseTransparent(false);
        firstNameTextField.setFocusTraversable(true);
        firstNameTextField.setEditable(true);

        firstNameButtonClicked = true;
    }

    //  called by clicking change button - makes field of last name fully editable
    @FXML
    private void updateLastName() {
        lastNameTextField.setText(lastName);
        lastNameTextField.setMouseTransparent(false);
        lastNameTextField.setFocusTraversable(true);
        lastNameTextField.setEditable(true);

        lastNameButtonClicked = true;
    }

    //  called by clicking change button - makes field of city fully editable
    @FXML
    private void updateCity() {
        cityTextField.setText(city);
        cityTextField.setMouseTransparent(false);
        cityTextField.setFocusTraversable(true);
        cityTextField.setEditable(true);

        cityButtonClicked = true;
    }

    //  called by clicking change button - makes field of age fully editable
    @FXML
    private void updateAge() {
        datePickerOfDoB.setEditable(true);
        datePickerOfDoB.setMouseTransparent(false);
        datePickerOfDoB.setFocusTraversable(true);

        ageButtonClicked = true;
    }

    //  called by clicking change button - makes field of email fully editable
    @FXML
    private void updateEmail() {
        emailTextField.setText(email);
        emailTextField.setEditable(true);
        emailTextField.setMouseTransparent(false);
        emailTextField.setFocusTraversable(true);

        emailButtonClicked = true;
    }

    //  called by clicking change button - makes field of password fully editable
    @FXML
    private void updatePassword() {
        passwordTextField.setText(password);
        passwordTextField.setEditable(true);
        passwordTextField.setMouseTransparent(false);
        passwordTextField.setFocusTraversable(true);

        passwordButtonClicked = true;
    }

    //  submit changes in updated fields, providing that they exist and are correct
    @FXML
    private void submitUpdates() {
        SignUpPageController check = new SignUpPageController();

        LocalDate dateLimit = LocalDate.now();
        dateLimit = dateLimit.minusYears(16);
        String emailRead = Main.getEmailIN();
        String sql;
        boolean checkIfUpdated = false;

        unableToWrite();

        try {
            if (firstNameButtonClicked && !firstName.equals(firstNameTextField.getText())) {
                bufor = firstNameTextField.getText();
                if (bufor.equals("")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("First name field is empty, enter sth!");
                    alert.showAndWait();
                    /*firstNameTextField.setPromptText("");
                    updateFirstName();*/
                    startrunning();
                    return;
                }
                /*firstNameTextField.setText("");
                firstNameTextField.setPromptText(bufor);*/
                firstName = bufor;
                sql = "update users set first_name = '" + firstName + "' where email ='" + emailRead + "'";
                Main.stmt.executeUpdate(sql);
                checkIfUpdated = true;
            }

            if (lastNameButtonClicked && !lastName.equals(lastNameTextField.getText())) {
                bufor = lastNameTextField.getText();
                if (bufor.equals("")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Last name field is empty, enter sth!");
                    alert.showAndWait();
                    /*lastNameTextField.setPromptText("");
                    updateLastName();*/
                    startrunning();
                    return;
                }
                /*lastNameTextField.setText("");
                lastNameTextField.setPromptText(bufor);*/
                lastName = bufor;
                sql = "update users set last_name = '" + lastName + "' where email ='" + emailRead + "'";
                Main.stmt.executeUpdate(sql);
                checkIfUpdated = true;
            }

            if (cityButtonClicked && !city.equals(cityTextField.getText())) {
                bufor = cityTextField.getText();
                if (bufor.equals("")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("City field is empty, enter sth!");
                    alert.showAndWait();
                    /*cityTextField.setPromptText("");
                    updateCity();*/
                    startrunning();
                    return;
                }
                /*cityTextField.setText("");
                cityTextField.setPromptText(bufor);*/
                city = bufor;
                sql = "update users set city = '" + city + "' where email ='" + emailRead + "'";
                Main.stmt.executeUpdate(sql);
                checkIfUpdated = true;
            }

            if (ageButtonClicked && !age.equals(datePickerOfDoB.getValue())) {

                if (datePickerOfDoB.getValue().isAfter(dateLimit)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("You must be at least 16 years old!");
                    alert.showAndWait();
                    startrunning();
                    return;
                    /*datePickerOfDoB.setPromptText("");
                    updateAge();*/
                } else {
                    /*datePickerOfDoB.setPromptText(datePickerOfDoB.getValue().toString());
                    age = datePickerOfDoB.getValue();*/
                    sql = "update users set DoB = '" + datePickerOfDoB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "' where email ='" + emailRead + "'";
                    Main.stmt.executeUpdate(sql);
                    checkIfUpdated = true;
                }
            }

            if (emailButtonClicked && !email.equals(emailTextField.getText())) {
                if (check.emailIsRepeating(emailTextField.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Email already exists in Database, insert new one");
                    alert.showAndWait();
                    /*emailTextField.setPromptText("");
                    updateEmail();*/
                    startrunning();
                    return;
                } else {
                    bufor = emailTextField.getText();
                    if (bufor.equals("")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setContentText("Email field is empty, enter sth!");
                        alert.showAndWait();
                        /*emailTextField.setPromptText("");
                        updateEmail();*/
                        startrunning();
                        return;
                    }
                    /*emailTextField.setText("");
                    emailTextField.setPromptText(bufor);*/
                    email = bufor;
                    sql = "update users set email = '" + email + "' where email ='" + emailRead + "'";
                    Main.stmt.executeUpdate(sql);
                    Main.setEmailIN(email);
                    checkIfUpdated = true;
                }
            }

            if (passwordButtonClicked && !password.equals(passwordTextField.getText())) {
                bufor = passwordTextField.getText();
                if (bufor.equals("")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Password field is empty, enter sth!");
                    alert.showAndWait();
                    /*passwordTextField.setPromptText("");
                    updatePassword();*/
                    startrunning();
                    return;
                }
                /*passwordTextField.setText("");
                passwordTextField.setPromptText(bufor);*/
                password = bufor;
                sql = "update users set password = '" + password + "' where email ='" + emailRead + "'";
                Main.stmt.executeUpdate(sql);
                checkIfUpdated = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (checkIfUpdated) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Data inserted");
            alert.showAndWait();
            loadProfile();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("There has been an error updating profile!\nREMARK: change ...");
            alert.showAndWait();
            loadProfile();
        }


    }

    /*
    ----------------------------------------------------------------------------------------------
    LOADERS METHODS - methods that loads other scenes
    ----------------------------------------------------------------------------------------------
     */
    @FXML
    private void loadProfile() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resources/profile.fxml"));
            BorderPane pane = loader.load();
            profilePane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToMainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/mainMenu.fxml"));
        BorderPane pane = loader.load();
        profilePane.getChildren().setAll(pane);
    }

    @FXML
    private void goToEvents() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/eventsPage.fxml"));
        BorderPane pane = loader.load();
        profilePane.getChildren().setAll(pane);
    }

    @FXML
    private void goToFriends() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/friendsPage.fxml"));
        loader.setLocation(getClass().getResource("/resources/friendsPage.fxml"));
        BorderPane pane = loader.load();
        profilePane.getChildren().setAll(pane);
    }

    @FXML
    private void goToChat() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/chatclient/FXMLDocument.fxml"));
        BorderPane pane = loader.load();
        profilePane.getChildren().setAll(pane);
    }

}

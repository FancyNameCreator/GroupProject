package JavaFX;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import java.sql.Date;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProfileController{
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

    private boolean firstNameButtonClicked=false;
    private boolean lastNameButtonClicked=false;
    private boolean cityButtonClicked=false;
    private boolean ageButtonClicked=false;
    private boolean emailButtonClicked=false;
    private boolean passwordButtonClicked=false;


    private String firstName;
    private String lastName;
    private String city;
    private LocalDate age;
    private String email;
    private String password;

    @FXML
    private void initialize(){
        startrunning();
    }

    @FXML
    private void startrunning(/*ActionEvent event*/){
        getData(Main.getEmailIN());
        printText();
        unableToWrite();
    }

    private void printText(){
        firstNameTextField.setPromptText(firstName);
        lastNameTextField.setPromptText(lastName);
        cityTextField.setPromptText(city);
        datePickerOfDoB.setPromptText(age.toString());
        emailTextField.setPromptText(email);
        passwordTextField.setPromptText("(NOT VISIBLE)");
    }

    private void unableToWrite(){
        firstNameTextField.setEditable(false);
        lastNameTextField.setEditable(false);
        cityTextField.setEditable(false);
        datePickerOfDoB.setEditable(false);
        emailTextField.setEditable(false);
        passwordTextField.setEditable(false);
    }



    private void getData(String emailPassed){
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

    @FXML
    private void updateFirstName(ActionEvent ae) {
        firstNameTextField.setText(firstName);
        firstNameTextField.setEditable(true);
        firstNameButtonClicked = true;
    }

    @FXML
    private void updateLastName(ActionEvent ae){
        lastNameTextField.setText(lastName);
        lastNameTextField.setEditable(true);
        lastNameButtonClicked = true;
    }

    @FXML
    private void updateCity(ActionEvent ae){
        lastNameTextField.setText(lastName);
        cityTextField.setEditable(true);
        cityButtonClicked = true;
    }

    @FXML
    private void updateAge(ActionEvent ae){
        datePickerOfDoB.setEditable(true);
        ageButtonClicked = true;
    }

    @FXML
    private void updateEmail(ActionEvent ae){
        emailTextField.setText(email);
        emailTextField.setEditable(true);
        emailButtonClicked= true;
    }

    @FXML
    private void updatePassword(ActionEvent ae){
        passwordTextField.setText(password);
        passwordTextField.setEditable(true);
        passwordButtonClicked = true;
    }

    @FXML
    private void submitUpdates(ActionEvent ae){
        SignUpPageController check = new SignUpPageController();


        LocalDate dateLimit = LocalDate.now();
        dateLimit = dateLimit.minusYears(16);
        String emailRead = Main.getEmailIN();
        String sql;
        boolean checkIfUpdated=false;

        unableToWrite();

        try {
            if (firstNameButtonClicked && !firstName.equals(firstNameTextField.getText())) {
                firstName = firstNameTextField.getText();
                sql = "update users set first_name = '" + firstName + "' where email ='" + emailRead + "'";
                if(firstName.equals("")){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("First Name field is empty, enter sth!");
                    alert.showAndWait();
                    return;
                }
                Main.stmt.executeUpdate(sql);
                checkIfUpdated=true;
            }

            if (lastNameButtonClicked && !lastName.equals(lastNameTextField.getText())){
                lastName = lastNameTextField.getText();
                sql = "update users set last_name = '" + lastName + "' where email ='" + emailRead + "'";
                if(lastName.equals("")){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("First Name field is empty, enter sth!");
                    alert.showAndWait();
                    return;
                }
                Main.stmt.executeUpdate(sql);
                checkIfUpdated=true;
            }

            if (cityButtonClicked && !city.equals(cityTextField.getText())){
                city = cityTextField.getText();
                sql = "update users set city = '" + city + "' where email ='" + emailRead + "'";
                if(city.equals("")){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("First Name field is empty, enter sth!");
                    alert.showAndWait();
                    return;
                }
                Main.stmt.executeUpdate(sql);
                checkIfUpdated=true;
            }

            if (ageButtonClicked && !age.equals(datePickerOfDoB.getValue())){
                age = datePickerOfDoB.getValue();

                if (datePickerOfDoB.getValue().isAfter(dateLimit)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("You must be at least 16 years old!");
                    alert.showAndWait();
                }else {
                    sql = "update users set DoB = '" + datePickerOfDoB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "' where email ='" + emailRead + "'";
                    Main.stmt.executeUpdate(sql);
                    checkIfUpdated = true;
                }
            }

            if (emailButtonClicked && !email.equals(emailTextField.getText())){
                if(check.emailIsRepeating(emailTextField.getText())){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Email already exists in Database, insert new one");
                    alert.showAndWait();
                } else {
                    email = emailTextField.getText();
                    sql = "update users set email = '" + email + "' where email ='" + emailRead + "'";
                    if(email.equals("")){
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setContentText("First Name field is empty, enter sth!");
                        alert.showAndWait();
                        return;
                    }
                    Main.stmt.executeUpdate(sql);
                    Main.setEmailIN(email);
                    checkIfUpdated = true;
                }
            }

            if (passwordButtonClicked && !password.equals(passwordTextField.getText())){
                password = passwordTextField.getText();
                sql = "update users set password = '" + password + "' where email ='" + emailRead + "'";
                if(password.equals("")){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("First Name field is empty, enter sth!");
                    alert.showAndWait();
                    return;
                }
                Main.stmt.executeUpdate(sql);
                checkIfUpdated=true;
            }



        }catch (SQLException e){
            e.printStackTrace();
        }

        if (checkIfUpdated){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Data inserted");
            alert.showAndWait();
            startrunning();
        } else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("You haven't updated profile!");
            alert.showAndWait();
            startrunning();
        }


    }

//the problem may be because going from border pane to anchor pane again
    @FXML
    private void goToMainMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/mainMenu.fxml"));
        BorderPane pane = loader.load();
        profilePane.getChildren().setAll(pane);
    }

    @FXML
    private void goToEvents(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/eventsPage.fxml"));
        BorderPane pane = loader.load();
        profilePane.getChildren().setAll(pane);
    }

    @FXML
    private void goToFriends(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/friendsPage.fxml"));
        loader.setLocation(getClass().getResource("/resources/friendsPage.fxml"));
        BorderPane pane = loader.load();
        profilePane.getChildren().setAll(pane);
    }

    @FXML
    private void goToChat(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/profilePage.fxml"));
        BorderPane pane = loader.load();
        profilePane.getChildren().setAll(pane);
    }

}

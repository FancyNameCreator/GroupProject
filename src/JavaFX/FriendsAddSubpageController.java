package JavaFX;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.*;

public class FriendsAddSubpageController {

    private Person person = new Person(Main.chosenOne.getId(), Main.chosenOne.getFirstName(), Main.chosenOne.getLastName(),
            Main.chosenOne.getEmail(), Main.chosenOne.getPassword(), Main.chosenOne.getCity(),
            Main.chosenOne.getDoB(), Main.chosenOne.getEventsAttending(), Main.chosenOne.getFriends());


    @FXML
    private BorderPane profilePane;

    @FXML
    private Button addFriendButton;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField DOBTextField;

    @FXML
    private void initialize() {
        firstNameTextField.setEditable(false);
        firstNameTextField.setMouseTransparent(true);
        firstNameTextField.setFocusTraversable(false);

        lastNameTextField.setEditable(false);
        lastNameTextField.setMouseTransparent(true);
        lastNameTextField.setFocusTraversable(false);

        cityTextField.setEditable(false);
        cityTextField.setMouseTransparent(true);
        cityTextField.setFocusTraversable(false);

        DOBTextField.setEditable(false);
        DOBTextField.setMouseTransparent(true);
        DOBTextField.setFocusTraversable(false);

        firstNameTextField.setText(person.getFirstName());
        lastNameTextField.setText(person.getLastName());
        cityTextField.setText(person.getCity());
        DOBTextField.setText(person.getDoB());
    }

    @FXML
    void addFriend() {
        /*
        TO DO:
         check if user already has some friends:
                if - YES - check if I can add this person (check if he is in my friends or not)
                        YES - STRING (minus) ')' (plus) ',' (plus) ID (plus) ')'
                        NO - ALERT
                if - NO - JUST ADD HIM - NO - ADD: '(' + ID + ')'
         */

        if (userHasFriends()) {
            if (isAlreadyFriendOfUser()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("You have this person already in followed people list");
                alert.showAndWait();
            } else {
                String stringOfIDs = getStringOfFriendsID();

                StringBuilder sb = new StringBuilder(stringOfIDs);

                sb.setLength(sb.length()-1);

                sb.append(",").append(Main.chosenOne.getId()).append(")");

                try {
                    String sql = "update users set friends = '" + sb.toString() + "' where email = '" + Main.getEmailIN() + "'";

                    // executing MySQL command that value is stored in sql variable
                    Main.stmt.executeUpdate(sql);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Friend added");
                    alert.showAndWait();

                } catch (SQLException e) {  // catch exception if occur
                    e.printStackTrace();
                }
            }
        } else {
            String command = "(" + person.getId() + ")";
            try {
                String sql = "update users set friends = '" + command + "' where email = '" + Main.getEmailIN() + "'";

                // executing MySQL command that value is stored in sql variable
                Main.stmt.executeUpdate(sql);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Person is added to your followed list");
                alert.showAndWait();

            } catch (SQLException e) {  // catch exception if occur
                e.printStackTrace();
            }
        }
        //CLOSE WINDOW
        Stage stage = (Stage) addFriendButton.getScene().getWindow();
        stage.close();

    }

    private boolean userHasFriends() {
        String str = "";
        try {
            ResultSet myResults = Main.stmt.executeQuery("select friends from users where email = '" + Main.getEmailIN() + "'");

            while (myResults.next()) {
                str = myResults.getString("friends");
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (str == null || str.equals(""))
            return false;
        else
            return true;
    }

    private String getStringOfFriendsID() {
        String str = "";

        try {
            ResultSet myResults = Main.stmt.executeQuery("select friends from users where email = '" + Main.getEmailIN() + "'");

            while (myResults.next()) {
                str = myResults.getString("friends");
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
        return str;
    }

    private boolean isAlreadyFriendOfUser() {
        String friends = "";
        String checking = "";

        try {
            ResultSet myResults = Main.stmt.executeQuery("select friends from users where email = '" + Main.getEmailIN() + "'");

            while (myResults.next()) {
                friends = myResults.getString("friends");
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        StringBuilder sb = new StringBuilder(checking);

        if (friends == null)
            return false;

        for (int i = 1; i < friends.length(); i++) {
            if (friends.charAt(i) != ',' && friends.charAt(i) != ')') {
                sb.append(friends.charAt(i));
            } else {
                if (sb.toString().equals(Main.chosenOne.getId()))
                    return true;
                sb.deleteCharAt(1);
                sb.deleteCharAt(0);
            }
        }
        return false;
    }
}

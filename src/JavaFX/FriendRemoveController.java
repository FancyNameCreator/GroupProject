package JavaFX;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * class responsible for removing a friend from a users friends, controller of friendRemove.fxml
 */
public class FriendRemoveController {

    private Person person = new Person(Main.chosenOne.getId(), Main.chosenOne.getFirstName(), Main.chosenOne.getLastName(),
            Main.chosenOne.getEmail(), Main.chosenOne.getPassword(), Main.chosenOne.getCity(),
            Main.chosenOne.getDoB(), Main.chosenOne.getEventsAttending(), Main.chosenOne.getFriends());

    @FXML
    private BorderPane profilePane;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField DoFTextField;

    @FXML
    private Button removeButton;


    // Load and set scene items correctly
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

        DoFTextField.setEditable(false);
        DoFTextField.setMouseTransparent(true);
        DoFTextField.setFocusTraversable(false);

        firstNameTextField.setText(person.getFirstName());
        lastNameTextField.setText(person.getLastName());
        cityTextField.setText(person.getCity());
        DoFTextField.setText(person.getDoB());
    }

    //  remove friend from the list of friends of current user
    @FXML
    void removeFriend() {
        /*
        load friends string from db
        delete from the inner of the string, discuss all conditions
            - ONLY FRIEND - delete whole string - DONE
            - IN THE MIDDLE - delete ID, THEN CHECK IF FOLLOWING CHAR IS ")", IF NOT delete following ","
         */
        String str = "";
        try {
            ResultSet myResults = Main.stmt.executeQuery("select friends from users where email = '" + Main.getEmailIN() + "'");

            while (myResults.next()) {
                str = myResults.getString("friends");
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder("(");

        if (str.length() == 4) {
            str = "";
            updateDB(str);
            return;
        } else {
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) != ',' && str.charAt(i) != ')') {
                    sb.append(str.charAt(i));
                } else {
                    if (sb.toString().equals(Main.chosenOne.getId())) {
                        if (str.charAt(i) == ')') {
                            result.setLength(result.length() - 3);
                            result.append(")");
                            break;
                        }
                        if (str.charAt(i) == ',') {
                            result.setLength(result.length() - 2);
                        }

                        sb.deleteCharAt(1);
                        sb.deleteCharAt(0);
                        continue;
                    }

                    sb.deleteCharAt(1);
                    sb.deleteCharAt(0);
                    result.append(str.charAt(i));
                    continue;
                }

                result.append(str.charAt(i));
            }
        }

        updateDB(result.toString());
    }

    //  update list of friends of a current user
    private void updateDB(String command) {
        try {
            String sql = "update users set friends = '" + command + "' where email = '" + Main.getEmailIN() + "'";

            // executing MySQL command that value is stored in sql variable
            Main.stmt.executeUpdate(sql);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Followed person is removed!");
            alert.showAndWait();

        } catch (SQLException e) {  // catch exception if occur
            e.printStackTrace();
        }

        //CLOSE WINDOW
        Stage stage = (Stage) removeButton.getScene().getWindow();
        stage.close();
    }

}

package JavaFX;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.sql.*;

public class FriendsAddSubpageController {

    private Person person = new Person(Main.chosenOne.getId(),Main.chosenOne.getFirstName(),Main.chosenOne.getLastName(),
            Main.chosenOne.getEmail(),Main.chosenOne.getPassword(),Main.chosenOne.getCity(),
            Main.chosenOne.getDoB(),Main.chosenOne.getEventsAttending(), Main.chosenOne.getFriends());


    @FXML
    private BorderPane profilePane;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField DOBTextField;

    @FXML
    private void initialize(){
        firstNameTextField.setEditable(false);
        lastNameTextField.setEditable(false);
        cityTextField.setEditable(false);
        DOBTextField.setEditable(false);

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
        /*
        if (userHasFriends()){
            if(isAlreadyFriendOfUser()){

            }else{
                String stringOfIDs = getStringOfFriendsID();
            }
        }else{
            String command = "(" + person.getId() + ")";
            try {
                String sql = "insert into users friends value '" + command + "' where id = '"+Main.getEmailIN()+"'";

                // executing MySQL command that value is stored in sql variable
                Main.stmt.executeUpdate(sql);

                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Friend added");
                alert.showAndWait();

            } catch (SQLException e) {  // catch exception if occur
                e.printStackTrace();
            }
        }*/
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

        if(str == null || str =="")
            return false;
        else
            return true;
    }
}

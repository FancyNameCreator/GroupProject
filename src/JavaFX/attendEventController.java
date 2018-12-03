package JavaFX;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class attendEventController {

    private Event event = new Event(Main.chosenEvent.getID(), Main.chosenEvent.getName(), Main.chosenEvent.getDate(), Main.chosenEvent.getLocation(), Main.chosenEvent.getDescription(), Main.chosenEvent.getCategory(), Main.chosenEvent.getParticipants(), Main.chosenEvent.getCreator());

    @FXML private void initialize() {
        nameField.setMouseTransparent(true);
        nameField.setFocusTraversable(false);

        dateField.setMouseTransparent(true);
        dateField.setFocusTraversable(false);

        locationField.setMouseTransparent(true);
        locationField.setFocusTraversable(false);

        categoryField.setMouseTransparent(true);
        categoryField.setFocusTraversable(false);

        descriptionField.setMouseTransparent(true);
        descriptionField.setFocusTraversable(false);

        participantsField.setMouseTransparent(true);
        participantsField.setFocusTraversable(false);

        creatorField.setMouseTransparent(true);
        creatorField.setFocusTraversable(false);

        nameField.setText(event.getName());
        dateField.setText(event.getDate());
        locationField.setText(event.getLocation());
        categoryField.setText(event.getCategory());
        descriptionField.setText(event.getDescription());
        participantsField.setText(event.printNiceParticipants(event.getParticipants()));
        creatorField.setText(event.getCreator());
    }

    @FXML private void attendEvent() throws SQLException {
            if (legibleToAttend()) {
                String eventsCommand = makeEventsCommand();
                String usersCommand = makeUsersCommand();

                Main.stmt.executeUpdate("update events set participants = '" + eventsCommand + "' where event_id ='" + event.getID() + "'");
                Main.stmt.executeUpdate("update users set events_attending = '" + usersCommand + "' where email ='" + Main.getEmailIN() + "'");

                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Event added to attended!");
                alert.showAndWait();
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("You CAN'T attend this event");
                alert.showAndWait();
            }
        Stage stage = (Stage) buttonAttend.getScene().getWindow();
        stage.close();

        }

    private String makeEventsCommand() {

        String str = " ";
        try {
            ResultSet myResults = Main.stmt.executeQuery("select participants from events where event_id = " + event.getID());

            while (myResults.next()) {
                str = myResults.getString("participants");
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (str == null || str.equals(""))
            return ("(" + getUsersID() + ")");


        StringBuilder sb = new StringBuilder(str);

        if (str.length() != 0) {
            if (str.charAt(str.length() - 1) == ')') {
                sb.deleteCharAt(str.length() - 1);
                sb.append(",").append(getUsersID()).append(")");
                return sb.toString();
            } else {
                str = "(" + getUsersID() + ")";
                return str;
            }
        } else {
            str = "(" + getUsersID() + ")";
            return str;
        }
    }

    private String makeUsersCommand() {

        String str = "test";
        try {
            ResultSet myResults = Main.stmt.executeQuery("select events_attending from users where email = '" + Main.getEmailIN() + "'");

            while (myResults.next()) {
                str = myResults.getString("events_attending");
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }


        if (str == null || str.equals(""))
            return ("(" + event.getID() + ")");

        if (str.length() != 0) {
            if (str.charAt(str.length() - 1) == ')') {
                StringBuilder sb = new StringBuilder(str);
                sb.deleteCharAt(str.length() - 1);
                sb.append(",").append(event.getID()).append(")");
                return sb.toString();
            } else {
                str = "(" + event.getID() + ")";
                return str;
            }
        } else {
            str = "(" + event.getID() + ")";
            return str;
        }

    }
    private String getUsersID() {
        String id = "-1";

        try {

            ResultSet myResults = Main.stmt.executeQuery("select * from users where email = '" + Main.getEmailIN() + "'");

            // 4. Process the result set
            while (myResults.next()) {
                id = myResults.getString("id");
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        return id;
    }

    private boolean legibleToAttend(){

        String attending="";
        String checking="";

        if(isTheUserCreator()){
            return false;
        }else {
            try {
                ResultSet myResults = Main.stmt.executeQuery("select events_attending from users where email = '" + Main.getEmailIN() + "'");

                while (myResults.next()) {
                    attending = myResults.getString("events_attending");
                }
            } catch (Exception exc) {    //catch the exception if occurs
                exc.printStackTrace();
            }

            StringBuilder sb = new StringBuilder(checking);

            if (attending == null || attending.equals(""))
                return true;

            if (attending.length() != 0) {
                for (int i = 1; i < attending.length(); i++) {
                    if (attending.charAt(i) != ',' && attending.charAt(i) != ')') {
                        sb.append(attending.charAt(i));
                    } else {
                        if (event.getID().equals(sb.toString()))
                            return false;
                        sb.deleteCharAt(1);
                        sb.deleteCharAt(0);
                    }
                }
                return true;
            } else {
                return true;
            }
        }
    }
    private boolean isTheUserCreator() {
        return event.getCreator().equals(Main.getEmailIN());
    }


    @FXML
    private TextArea nameField;

    @FXML
    private TextArea dateField;

    @FXML
    private TextArea locationField;

    @FXML
    private TextArea categoryField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private TextArea participantsField;

    @FXML
    private TextArea creatorField;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button buttonAttend;

}

package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * class responsible for discover page (discover.fxml)
 */
public class DiscoverController {

    private ObservableList<String> usersChoice = FXCollections.observableArrayList("Food event", "Clubbing", "Music event", "Just meeting", "Sport match", "Hobby event");
    private ObservableList<Event> tableOfDiscover = FXCollections.observableArrayList();
    private Event evantSelected;

    @FXML
    private ChoiceBox<String> choiceBoxDiscover;

    @FXML
    private Button attendButton;

    @FXML
    private TextArea textAreaDescription;
    @FXML
    private TextArea textAreaParticipants;

    @FXML
    private BorderPane borderPaneDiscover;

    @FXML
    private TableView<Event> tableViewDiscover;
    @FXML
    private TableColumn<Event, String> eventNameColumnDiscover;
    @FXML
    private TableColumn<Event, String> eventLocationColumnDiscover;
    @FXML
    private TableColumn<Event, String> eventDateColumnDiscover;
    @FXML
    private TableColumn<Event, String> eventCategoryColumnCategory;
    @FXML
    private TableColumn<Event, String> eventCreatorColumnDiscover;

    //  set all the items of the scene and initialize them
    @FXML
    private void initialize() {
        choiceBoxDiscover.setItems(usersChoice);
        eventNameColumnDiscover.setCellValueFactory(new PropertyValueFactory<>("name"));
        eventDateColumnDiscover.setCellValueFactory(new PropertyValueFactory<>("date"));
        eventLocationColumnDiscover.setCellValueFactory(new PropertyValueFactory<>("location"));
        eventCategoryColumnCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        eventCreatorColumnDiscover.setCellValueFactory(new PropertyValueFactory<>("creator"));
        tableViewDiscover.setItems(tableOfDiscover);
        attendButton.setDisable(true);
    }

    //  determine which category of events to load
    @FXML
    private void showTableDiscover() {
        switch (choiceBoxDiscover.getValue()) {
            case ("Food event"):
                loadFoodEvents();
                break;
            case ("Clubbing"):
                loadClubbingEvents();
                break;
            case ("Music event"):
                loadMusicEvents();
                break;
            case ("Just meeting"):
                loadMeetingsEvents();
                break;
            case ("Sport match"):
                loadSportsEvents();
                break;
            case ("Hobby event"):
                loadHobbyEvents();
                break;
            default:
                System.out.println("YOU'VE BETTER LEARN HOW TO USE JFX!");
        }
    }

    //  show details of a chosen event
    @FXML
    private void showDetails() {
        attendButton.setDisable(false);
        evantSelected = tableViewDiscover.getSelectionModel().getSelectedItem();
        textAreaDescription.setText(evantSelected.getDescription());
        textAreaParticipants.setText(Event.printNiceParticipants(evantSelected.getParticipants()));
    }

    //  executes numerous functions to make user attend the event
    @FXML
    private void attendEvent() throws SQLException {

        if (legibleToAttend()) {
            String eventsCommand = makeEventsCommand();
            String usersCommand = makeUsersCommand();

            Main.stmt.executeUpdate("update events set participants = '" + eventsCommand + "' where event_id ='" + evantSelected.getID() + "'");
            Main.stmt.executeUpdate("update users set events_attending = '" + usersCommand + "' where email ='" + Main.getEmailIN() + "'");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Event added to attended!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("You CAN'T attend this event");
            alert.showAndWait();
        }
    }

    //  checks if current user is legible to attend an event
    private boolean legibleToAttend() {

        String attending = "";
        String checking = "";

        if (isTheUserCreator()) {
            return false;
        } else {
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
                        if (evantSelected.getID().equals(sb.toString()))
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

    //  checks if current user is a creator of an event
    private boolean isTheUserCreator() {
        return evantSelected.getCreator().equals(Main.getEmailIN());
    }

    //  Prepare a new string that would be inserted into the DB in events -> participants
    private String makeEventsCommand() {

        String str = " ";
        try {
            ResultSet myResults = Main.stmt.executeQuery("select participants from events where event_id = " + evantSelected.getID());

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

    //  Prepare a new string that would be inserted into the DB in users -> attending
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
            return ("(" + evantSelected.getID() + ")");

        if (str.length() != 0) {
            if (str.charAt(str.length() - 1) == ')') {
                StringBuilder sb = new StringBuilder(str);
                sb.deleteCharAt(str.length() - 1);
                sb.append(",").append(evantSelected.getID()).append(")");
                return sb.toString();
            } else {
                str = "(" + evantSelected.getID() + ")";
                return str;
            }
        } else {
            str = "(" + evantSelected.getID() + ")";
            return str;
        }

    }

    //  gets id of a current user of an application
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


    /*
    -----------------------------------------------------------------------------------------------------------
    LOADERS METHODS
    -----------------------------------------------------------------------------------------------------------
     */
    private void loadFoodEvents() {
        try {
            tableViewDiscover.getItems().clear();

            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_category = \"Food event\"");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                tableOfDiscover.add(new Event(ID, name, date, location, description, category, participants, creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }


    private void loadClubbingEvents() {
        try {
            tableViewDiscover.getItems().clear();
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_category = \"Clubbing\"");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                tableOfDiscover.add(new Event(ID, name, date, location, description, category, participants, creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    private void loadMusicEvents() {
        try {
            tableViewDiscover.getItems().clear();
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_category = \"Music event\"");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                tableOfDiscover.add(new Event(ID, name, date, location, description, category, participants, creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    private void loadMeetingsEvents() {
        try {
            tableViewDiscover.getItems().clear();
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_category = \"Just meeting\"");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                tableOfDiscover.add(new Event(ID, name, date, location, description, category, participants, creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    private void loadSportsEvents() {
        try {
            tableViewDiscover.getItems().clear();
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_category = \"Sport match\"");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                tableOfDiscover.add(new Event(ID, name, date, location, description, category, participants, creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    private void loadHobbyEvents() {
        try {
            tableViewDiscover.getItems().clear();
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_category = \"Hobby event\"");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                tableOfDiscover.add(new Event(ID, name, date, location, description, category, participants, creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }


    @FXML
    private void BackToEvents() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/eventsPage.fxml"));
        BorderPane pane = loader.load();
        borderPaneDiscover.getChildren().setAll(pane);
    }

}

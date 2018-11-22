package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiscoverController {

    private ObservableList<String> usersChoice = FXCollections.observableArrayList(
            "Food event", "Clubbing", "Music event", "Just meeting", "Sport match", "Hobby event");
    private ObservableList<Event> tableOfDiscover = FXCollections.observableArrayList();

    Event evantSelected;

    @FXML
    private ChoiceBox<String> choiceBoxDiscover;

    @FXML
    private TextArea textAreaDescription;
    @FXML
    private TextArea textAreaParticipants;


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


    @FXML
    private void initialize() {
        choiceBoxDiscover.setItems(usersChoice);
        eventNameColumnDiscover.setCellValueFactory(new PropertyValueFactory<>("name"));
        eventDateColumnDiscover.setCellValueFactory(new PropertyValueFactory<>("date"));
        eventLocationColumnDiscover.setCellValueFactory(new PropertyValueFactory<>("location"));
        eventCategoryColumnCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        eventCreatorColumnDiscover.setCellValueFactory(new PropertyValueFactory<>("creator"));
        tableViewDiscover.setItems(tableOfDiscover);
    }

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
    private void showDetails() {
        evantSelected = tableViewDiscover.getSelectionModel().getSelectedItem();
        textAreaDescription.setText(evantSelected.getDescription());
        textAreaParticipants.setText(evantSelected.getParticipants());
        System.out.println(evantSelected.getID());
    }

    @FXML
    private void attendEvent() throws SQLException {
        // CHECK IF ALREADY ATTENDING!!!
        // CANT ATTEND EVENTS MADE BY OURSELF
        legibleToAttend();

        String eventsCommand = makeEventsCommand();
        String usersCommand = makeUsersCommand();

        Main.stmt.executeUpdate("update events set participants = '" + eventsCommand + "' where event_id ='" + evantSelected.getID() + "'");
        Main.stmt.executeUpdate("update users set events_attending = '" + usersCommand + "' where email ='" + Main.getEmailIN() + "'");
    }

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

        if (str == null)
            str = "test";


        StringBuilder sb = new StringBuilder(str);

        if (str.charAt(str.length() - 1) == ')') {
            sb.deleteCharAt(str.length() - 1);
            sb.append(",").append(getUsersID()).append(")");
            return sb.toString();
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

        if (str == null)
            str = "test";

        StringBuilder sb = new StringBuilder(str);

        if (str.charAt(str.length() - 1) == ')') {
            sb.deleteCharAt(str.length()-1);
            sb.append(",").append(evantSelected.getID()).append(")");
            return sb.toString();
        } else {
            str = "(" + evantSelected.getID() + ")";
            return str;
        }

    }

    private String getUsersID() {
        String id = "-1";

        try {
            String email = Main.getEmailIN();

            ResultSet myResults = Main.stmt.executeQuery("select * from users where email = '" + email + "'");

            // 4. Process the result set
            while (myResults.next()) {
                id = myResults.getString("id");
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        System.out.println("Users id " + id);
        return id;
    }

    private boolean legibleToAttend(){
        return false;
    }

}

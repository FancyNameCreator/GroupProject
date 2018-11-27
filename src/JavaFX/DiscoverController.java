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

public class DiscoverController {

    @FXML
    private BorderPane borderPaneDiscover;

    @FXML
    private void BackToEvents() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/eventsPage.fxml"));
        BorderPane pane = loader.load();
        borderPaneDiscover.getChildren().setAll(pane);
    }

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
        textAreaParticipants.setText(Event.printNiceParticipants(evantSelected.getParticipants()));        ;

        System.out.println(evantSelected.getID());
    }

    @FXML
    private void attendEvent() throws SQLException {
        // CHECK IF ALREADY ATTENDING!!!
        // CANT ATTEND EVENTS MADE BY OURSELF

        if (legibleToAttend()) {
            String eventsCommand = makeEventsCommand();
            String usersCommand = makeUsersCommand();

            Main.stmt.executeUpdate("update events set participants = '" + eventsCommand + "' where event_id ='" + evantSelected.getID() + "'");
            Main.stmt.executeUpdate("update users set events_attending = '" + usersCommand + "' where email ='" + Main.getEmailIN() + "'");
        }else{
            System.out.println("You cant attend event");
        }
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

    public String getUsersID() {
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

        System.out.println("Users id " + id);
        return id;
    }

    private boolean legibleToAttend(){
        //pobrać liste uczestnikow i sprawdzic czy mnie tam nie ma
        //jak nie ma czy jestem creatorem
        //jak nie jestem to return true;
        //else fuck you

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

            if (attending == null/* && attending.length() == 1*/)
                return true;

            if (attending.length() != 1) {
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

    private boolean isTheUserCreator() {
        return evantSelected.getCreator().equals(Main.getEmailIN());
    }

}

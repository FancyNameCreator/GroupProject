package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.ResultSet;

public class MyEventsController {

    private ObservableList<Event> table = FXCollections.observableArrayList();
    private ObservableList<Event> tableOfCreated = FXCollections.observableArrayList();

    int lastIndex = 0;

    @FXML
    private void initialize(){
        loadEventsTableAttending();
        loadEventsTableCreated();
        eventNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        eventDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        eventLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        eventCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        eventCreatorColumn.setCellValueFactory(new PropertyValueFactory<>("creator"));
        tableView.setItems(table);

        eventNameColumnCreated.setCellValueFactory(new PropertyValueFactory<>("name"));
        eventDateColumnCreated.setCellValueFactory(new PropertyValueFactory<>("date"));
        eventLocationColumnCreated.setCellValueFactory(new PropertyValueFactory<>("location"));
        eventCategoryColumnCreated.setCellValueFactory(new PropertyValueFactory<>("category"));
        eventCreatorColumnCreated.setCellValueFactory(new PropertyValueFactory<>("creator"));
        tableViewOfCreatedEvents.setItems(tableOfCreated);
    }

    private void loadEventsTableAttending(){
        String idOfEventsIdAttending  = getEventsOfUserAttending();

        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_id in " + idOfEventsIdAttending);

            // 4. Process the result set
            while (myResults.next()) {
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                table.add(new Event(name,date,location,description,category,participants,creator));
                //lastIndex ++;

            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    private void loadEventsTableCreated(){

        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where creator = '" + Main.getEmailIN() + "'");

            // 4. Process the result set
            while (myResults.next()) {
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                tableOfCreated.add(new Event(name,date,location,description,category,participants,creator));
                //lastIndex ++;

            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    private String getEventsOfUserAttending(){
        String str = "";

        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select events_attending from users where email = '" + Main.getEmailIN() + "' ");

            // 4. Process the result set
            while (myResults.next())
                str = (myResults.getString("events_attending"));

        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
        return str;
    }

    @FXML
    private void showDetails(){
        Event evantSelected = tableView.getSelectionModel().getSelectedItem();
        System.out.println(evantSelected.getName());
        System.out.println(evantSelected.getLocation());
    }

    @FXML private TableView<Event> tableView;

    @FXML private TableColumn<Event, String> eventNameColumn;

    @FXML private TableColumn<Event, String> eventDateColumn;

    @FXML private TableColumn<Event, String> eventLocationColumn;

    @FXML private TableColumn<Event, String> eventCategoryColumn;

    @FXML private TableColumn<Event, String> eventCreatorColumn;


    @FXML private TableView<Event> tableViewOfCreatedEvents;

    @FXML private TableColumn<Event, String> eventNameColumnCreated;

    @FXML private TableColumn<Event, String> eventDateColumnCreated;

    @FXML private TableColumn<Event, String> eventLocationColumnCreated;

    @FXML private TableColumn<Event, String> eventCategoryColumnCreated;

    @FXML private TableColumn<Event, String> eventCreatorColumnCreated;


}
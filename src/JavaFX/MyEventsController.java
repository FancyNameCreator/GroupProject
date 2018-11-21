package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class MyEventsController {

    private ObservableList<Event> table = FXCollections.observableArrayList();

    int lastIndex = 0;

    @FXML
    private void initialize(){
        loadEventsTable(Main.getEmailIN());
        eventNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        eventDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        eventLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        eventCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        eventCreatorColumn.setCellValueFactory(new PropertyValueFactory<>("creator"));
        tableView.setItems(table);
    }

    private void loadEventsTable(String email){
        String idOfEventsIdAttending  = getEventsOfUser();

        try {
                // 3. Execute SQL query
                ResultSet myResults = Main.stmt.executeQuery("select * from events where event_id = '"+idOfEventsIdAttending+"'");

                // 4. Process the result set
                while (myResults.next()) {
                    String name = myResults.getString("event_name");
                    String date = myResults.getString("event_date");
                    String location = myResults.getString("event_location");
                    String category = myResults.getString("event_category");
                    String creator = myResults.getString("creator");
                    table.add(new Event(name,date,location,category,creator));
                    lastIndex ++;

                }
            } catch (Exception exc) {    //catch the exception if occurs
                exc.printStackTrace();
            }
    }

    public String getEventsOfUser(){
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
    private BorderPane root;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabAttending;

    @FXML
    private ScrollPane scroll;

    @FXML
    private TableView<Event> tableView;

    @FXML
    private TableColumn<Event, String> eventNameColumn;

    @FXML
    private TableColumn<Event, String> eventDateColumn;

    @FXML
    private TableColumn<Event, String> eventLocationColumn;

    @FXML
    private TableColumn<Event, String> eventCategoryColumn;

    @FXML
    private TableColumn<Event, String> eventCreatorColumn;

    @FXML
    private Tab tabCreated;

    @FXML
    private Label mainLabel;

}

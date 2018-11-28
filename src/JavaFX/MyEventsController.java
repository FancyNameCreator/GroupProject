package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MyEventsController {

    private ObservableList<Event> table = FXCollections.observableArrayList();
    private ObservableList<Event> tableOfCreated = FXCollections.observableArrayList();


    @FXML
    private BorderPane myEventsPane;

    @FXML
    private void BackToEvents() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/eventsPage.fxml"));
        BorderPane pane = loader.load();
        myEventsPane.getChildren().setAll(pane);
    }

    @FXML
    private void initialize(){
        textAreaParticipants.setEditable(false);
        textAreaDescription.setEditable(false);

        if (!getEventsOfUserAttending().equals("") || getEventsOfUserAttending().equals(null)) {
            loadEventsTableAttending();
            eventNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            eventDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            eventLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
            eventCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
            eventCreatorColumn.setCellValueFactory(new PropertyValueFactory<>("creator"));
            tableView.setItems(table);
        } else {
            showAlert("You are not attending any events :(");
        }

        if (loadEventsTableCreated()) {
            eventNameColumnCreated.setCellValueFactory(new PropertyValueFactory<>("name"));
            eventDateColumnCreated.setCellValueFactory(new PropertyValueFactory<>("date"));
            eventLocationColumnCreated.setCellValueFactory(new PropertyValueFactory<>("location"));
            eventCategoryColumnCreated.setCellValueFactory(new PropertyValueFactory<>("category"));
            eventCreatorColumnCreated.setCellValueFactory(new PropertyValueFactory<>("creator"));
            tableViewOfCreatedEvents.setItems(tableOfCreated);
        } else {
            showAlert("You haven't created any events :(");
        }

        tableViewOfCreatedEvents.setEditable(true);
        eventNameColumnCreated.setCellFactory(TextFieldTableCell.forTableColumn());
        eventDateColumnCreated.setCellFactory(TextFieldTableCell.forTableColumn());
        eventLocationColumnCreated.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void changeEventName (TableColumn.CellEditEvent edittedCell) {

        Event choosenEvent = tableViewOfCreatedEvents.getSelectionModel().getSelectedItem();
        choosenEvent.setName(edittedCell.getNewValue().toString());

        try {
            String sql = "update events set event_name = '"+ edittedCell.getNewValue() +"' where event_id = '" + choosenEvent.getID() + "'";

            Main.stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void changeEventDate (TableColumn.CellEditEvent edittedCell) {
        Event choosenEvent = tableViewOfCreatedEvents.getSelectionModel().getSelectedItem();
        choosenEvent.setDate(edittedCell.getNewValue().toString());

        try {
            String sql = "update events set event_date = '"+ edittedCell.getNewValue() +"' where event_id = '"+ choosenEvent.getID() + "' ";

            Main.stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void changeEventLocation (TableColumn.CellEditEvent edittedCell) {
        Event choosenEvent = tableViewOfCreatedEvents.getSelectionModel().getSelectedItem();
        choosenEvent.setLocation(edittedCell.getNewValue().toString());

        try {
            String sql = "update events set event_location = '"+ edittedCell.getNewValue() +"' where event_id = '"+ choosenEvent.getID() + "'";
            Main.stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeEventCategory (TableColumn.CellEditEvent edittedCell) {
        Event choosenEvent = tableViewOfCreatedEvents.getSelectionModel().getSelectedItem();
    }

    private void loadEventsTableAttending(){
        String idOfEventsIdAttending  = getEventsOfUserAttending();
        //System.out.println(idOfEventsIdAttending);

        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_id in " + idOfEventsIdAttending);

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
                table.add(new Event(ID,name,date,location,description,category,participants,creator));

            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    private boolean loadEventsTableCreated(){

        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where creator = '" + Main.getEmailIN() + "'");

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
                tableOfCreated.add(new Event(ID,name,date,location,description,category,participants,creator));
                //lastIndex ++;

            }

            if (tableOfCreated==null) {
                return false;
            }

        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }


        return true;
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
        textAreaDescription.setText(evantSelected.getDescription());
        textAreaParticipants.setText(Event.printNiceParticipants(evantSelected.getParticipants()));        ;
    }

    @FXML
    private void showDetailsOfCreated(){
        Event evantSelected = tableViewOfCreatedEvents.getSelectionModel().getSelectedItem();
        textAreaDescription.setText(evantSelected.getDescription());
        textAreaParticipants.setText(Event.printNiceParticipants(evantSelected.getParticipants()));        ;
    }

    private void showAlert(String string){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(string);
        alert.showAndWait();
    }

    @FXML private TableView<Event> tableView;

    @FXML private TableColumn<Event, String> eventNameColumn;
    @FXML private TableColumn<Event, String> eventDateColumn;
    @FXML private TableColumn<Event, String> eventLocationColumn;
    @FXML private TableColumn<Event, String> eventCategoryColumn;
    @FXML private TableColumn<Event, String> eventCreatorColumn;
    @FXML private DatePicker datePicker;


    @FXML private TableView<Event> tableViewOfCreatedEvents;

    @FXML private TableColumn<Event, String> eventNameColumnCreated;
    @FXML private TableColumn<Event, String> eventDateColumnCreated;
    @FXML private TableColumn<Event, String> eventLocationColumnCreated;
    @FXML private TableColumn<Event, String> eventCategoryColumnCreated;
    @FXML private TableColumn<Event, String> eventCreatorColumnCreated;

    @FXML private TextArea textAreaDescription;
    @FXML private TextArea textAreaParticipants;

}
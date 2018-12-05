package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

/**
 * class is responsible for createEvent.fxml
 */
public class CreateEventController {

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldLocation;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField textFieldDescription;

    @FXML
    private ChoiceBox<String> choiceBoxCreate;

    @FXML
    private Button buttonCreate;

    @FXML
    private BorderPane CreateEventsPane;

    @FXML
    private Label labelEventCreated;

    private String nameOfEvent;
    private String locationOfEvent;
    private String dateOfEvent;
    private String descriptionOfEvent;
    private String categoryOfEvent;
    private String participantsOfEvent;
    private String creatorOfEvent = Main.getEmailIN();

    private ObservableList<String> category = FXCollections.observableArrayList(
            "Food event", "Clubbing", "Music event", "Just meeting", "Sport match", "Hobby event");


    @FXML
    private void initialize() {
        choiceBoxCreate.setItems(category);
    }

    //  called by clicking create button
    @FXML
    private void createEvent() {
        if(!getData()) {
            nameOfEvent = "";
            locationOfEvent = "";
            dateOfEvent = "";
            descriptionOfEvent = "";
            categoryOfEvent = "";
            return;
        }

        if (checking()) {
            sendData();
            showAlert();
            backToEvents();
        }
    }

    //  collects data from all the fields and initializes the variables;
    private boolean getData() {
        nameOfEvent = textFieldName.getText();
        locationOfEvent = textFieldLocation.getText();

        if (datePicker.getValue()==null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You forgot of filling your event date!");
            alert.showAndWait();
            return false;
        }

        dateOfEvent = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        descriptionOfEvent = textFieldDescription.getText();
        participantsOfEvent = "";
        creatorOfEvent = Main.getEmailIN();

        if (choiceBoxCreate.getValue()==null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You forgot of filling your event category!");
            alert.showAndWait();
            return false;
        }

        categoryOfEvent = choiceBoxCreate.getValue();

        return true;
    }

    private boolean checking(/*String nameOfEvent, String locationOfEvent, String dateOfEvent, String description, String categoryOfEvent*/) {

        if (nameOfEvent.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Name of an event field is empty, enter sth!");
            alert.showAndWait();
            return false;
        }

        if (locationOfEvent.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Location of an event field is empty, enter sth!");
            alert.showAndWait();
            return false;
        }

        if (dateOfEvent.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Date of an event field is empty, enter sth!");
            alert.showAndWait();
            return false;
        }

        if (descriptionOfEvent.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Description field is empty, enter sth!");
            alert.showAndWait();
            return false;
        }

        if (categoryOfEvent.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Category field is empty, enter sth!");
            alert.showAndWait();
            return false;
        }

        return true;
    }


    //  sends data into the DB
    private void sendData() {
        try {
            String sql = "insert into events "
                    + "(event_name,event_date,event_location,event_description,event_category,participants,creator)"
                    + "values ('" + nameOfEvent + "','" + dateOfEvent + "','" + locationOfEvent + "','" + descriptionOfEvent + "','" + categoryOfEvent + "','" + participantsOfEvent + "', '" + creatorOfEvent + "')";
            // executing MySQL command that value is stored in sql variable
            Main.stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        labelEventCreated.setVisible(true);
    }

    //  shows alert that event was created
    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Event created!");
        alert.showAndWait();
    }

    //  LOADER
    @FXML
    private void backToEvents() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resources/eventsPage.fxml"));
            BorderPane pane = loader.load();
            CreateEventsPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class CreateEventController {

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldLocation;

    @FXML
    private TextField textFieldDate;

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

    @FXML
    private void BackToEvents() throws IOException {
    FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/eventsPage.fxml"));
    BorderPane pane = loader.load();
        CreateEventsPane.getChildren().setAll(pane);
}

    String nameOfEvent;
    String locationOfEvent;
    String dateOfEvent;
    String descriptionOfEvent;
    String categoryOfEvent;
    String participantsOfEvent;
    String creatorOfEvent = Main.getEmailIN();

    private ObservableList<String> category = FXCollections.observableArrayList(
            "Food event","Clubbing","Music event","Just meeting","Sport match","Hobby event");

    @FXML
    private void initialize(){
        choiceBoxCreate.setItems(category);
    }

    @FXML
    private void createEvent(ActionEvent ae){
        getData();
        sendData();
    }

    private void getData(){
        nameOfEvent = textFieldName.getText();
        locationOfEvent = textFieldLocation.getText();
        dateOfEvent = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        descriptionOfEvent = textFieldDescription.getText();
        participantsOfEvent = "";
        creatorOfEvent = Main.getEmailIN();
        categoryOfEvent = choiceBoxCreate.getValue();
        }

    private void sendData(){
        try{
            String sql = "insert into events "
                    + "(event_name,event_date,event_location,event_description,event_category,participants,creator)"
                    + "values ('" + nameOfEvent + "','" + dateOfEvent + "','" + locationOfEvent + "','" + descriptionOfEvent + "','" + categoryOfEvent + "','" + participantsOfEvent + "', '" + creatorOfEvent + "')";
            // executing MySQL command that value is stored in sql variable
            Main.stmt.executeUpdate(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
        labelEventCreated.setVisible(true);




    }
}

package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class CreateEventController {

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldLocation;

    @FXML
    private TextField textFieldDate;

    @FXML
    private TextField textFieldDescription;

    @FXML
    private ChoiceBox<String> choiceBoxCreate;

    @FXML
    private Button buttonCreate;

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
        dateOfEvent = textFieldDate.getText();
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


    }
}

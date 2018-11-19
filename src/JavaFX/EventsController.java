package JavaFX;

import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class EventsController {
    ObservableList<String> usersChoice = FXCollections.observableArrayList("My events(attended/to attend and created)", "Discover(search by category and attend)", "Events my friend created", "Create event");

    @FXML
    private ChoiceBox <String> choicebox;

    @FXML
    private Label labelOfUserChoice;

    @FXML
    private void initialize(){
        choicebox.setItems(usersChoice);
    }

    @FXML
    private void changeLabel(ActionEvent ae){

        switch (choicebox.getValue()) {
            case ("My events(attended/to attend and created)"):
                labelOfUserChoice.setText("You have chosen: " + choicebox.getValue());
                break;
            case ("Discover(search by category and attend)"):
                labelOfUserChoice.setText("You have chosen: " + choicebox.getValue());
                break;
            case ("Events my friend created"):
                labelOfUserChoice.setText("You have chosen: " + choicebox.getValue());
                break;
            case ("Create event"):
                labelOfUserChoice.setText("You have chosen: " + choicebox.getValue());
                break;
            default:
                System.out.println("YOU'VE BETTER LEARN HOW TO USE JFX!");
        }
    }

}

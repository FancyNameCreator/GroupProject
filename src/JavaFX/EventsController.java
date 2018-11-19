package JavaFX;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class EventsController {
    private ObservableList<String> usersChoice = FXCollections.observableArrayList("My events(attended/to attend and created)", "Discover(search by category and attend)", "Events my friend created", "Create event");

    @FXML
    private BorderPane eventsPane;

    @FXML
    private ChoiceBox <String> choicebox;

    @FXML
    private Label labelOfUserChoice;

    @FXML
    private void initialize(){
        choicebox.setItems(usersChoice);
    }

    @FXML
    private void changeLabel() throws IOException{

        switch (choicebox.getValue()) {
            case ("My events(attended/to attend and created)"):
                labelOfUserChoice.setText("You have chosen: " + choicebox.getValue());
                loadMyEvents();
                break;
            case ("Discover(search by category and attend)"):
                labelOfUserChoice.setText("You have chosen: " + choicebox.getValue());
                loadDiscover();
                break;
            case ("Events my friends are going/created"):
                labelOfUserChoice.setText("You have chosen: " + choicebox.getValue());
                loadFriendsEvents();
                break;
            case ("Create event"):
                labelOfUserChoice.setText("You have chosen: " + choicebox.getValue());
                loadCreateEvent();
                break;
            default:
                System.out.println("YOU'VE BETTER LEARN HOW TO USE JFX!");
        }
    }

    private void loadMyEvents() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/myEvents.fxml"));
        BorderPane pane = loader.load();
        eventsPane.getChildren().setAll(pane);
    }

    private void loadDiscover() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/discover.fxml"));
        BorderPane pane = loader.load();
        eventsPane.getChildren().setAll(pane);
    }

    private void loadFriendsEvents() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/friendsEvents.fxml"));
        BorderPane pane = loader.load();
        eventsPane.getChildren().setAll(pane);
    }

    private void loadCreateEvent() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/createEvent.fxml"));
        BorderPane pane = loader.load();
        eventsPane.getChildren().setAll(pane);
    }

}

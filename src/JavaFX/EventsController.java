package JavaFX;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class EventsController {
    private ObservableList<String> usersChoice = FXCollections.observableArrayList("My events(attended/to attend and created)", "Discover(search by category and attend)", "Create event");

    @FXML
    private BorderPane eventsPane;

    @FXML
    private ChoiceBox<String> choicebox;


    @FXML
    private Label labelOfUserChoice;


    @FXML
    private void initialize() {
        choicebox.setItems(usersChoice);
    }

    @FXML
    private void changeLabel() throws IOException{

        switch (choicebox.getValue()) {

            case ("My events(attended/to attend and created)"):
                labelOfUserChoice.setText("You have chosen: " + choicebox.getValue());
                choicebox.setDisable(true);
                loadMyEvents();
                break;
            case ("Discover(search by category and attend)"):
                labelOfUserChoice.setText("You have chosen: " + choicebox.getValue());
                choicebox.setDisable(true);
                loadDiscover();
                break;
            case ("Create event"):
                labelOfUserChoice.setText("You have chosen: " + choicebox.getValue());
                loadCreateEvent();
                break;
        }
    }


    /*
    ----------------------------------------------------------------------------------------------------
    LOADERS METHODS
    ----------------------------------------------------------------------------------------------------
     */
    @FXML
    private void goToMainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/mainMenu.fxml"));
        BorderPane pane = loader.load();
        eventsPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToProfile() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/profile.fxml"));
        BorderPane pane = loader.load();
        eventsPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToFriends() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/friendsPage.fxml"));
        loader.setLocation(getClass().getResource("/resources/friendsPage.fxml"));
        BorderPane pane = loader.load();
        eventsPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToChat() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/chatclient/FXMLDocument.fxml"));
        BorderPane pane = loader.load();
        eventsPane.getChildren().setAll(pane);
    }

    private void loadMyEvents() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/myEvents.fxml"));
        BorderPane pane = loader.load();
        eventsPane.getChildren().setAll(pane);
    }

    private void loadDiscover() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/discover.fxml"));
        BorderPane pane = loader.load();
        eventsPane.getChildren().setAll(pane);
    }

    private void loadCreateEvent() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/createEvent.fxml"));
        BorderPane pane = loader.load();
        eventsPane.getChildren().setAll(pane);
    }

}

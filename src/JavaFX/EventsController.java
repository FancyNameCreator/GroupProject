package JavaFX;

import javafx.collections.*;
import javafx.event.ActionEvent;
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
    private ChoiceBox <String> choicebox;


    @FXML
    private Label labelOfUserChoice;

    @FXML
    private void initialize(){
        choicebox.setItems(usersChoice);

        //choicebox.getSelectionModel().selectedItemProperty().addListener(changeListener);
    }

    @FXML
    private void changeLabel() throws IOException/*, InterruptedException*/{

        switch (choicebox.getValue()) {

            //ask sokol about it

            case ("My events(attended/to attend and created)"):
                labelOfUserChoice.setText("You have chosen: " + choicebox.getValue());
                choicebox.setDisable(true);
                //TimeUnit.SECONDS.sleep(5);
                loadMyEvents();
                break;
            case ("Discover(search by category and attend)"):
                labelOfUserChoice.setText("You have chosen: " + choicebox.getValue());
                choicebox.setDisable(true);
                //TimeUnit.SECONDS.sleep(1);
                loadDiscover();
                break;
            case ("Create event"):
                labelOfUserChoice.setText("You have chosen: " + choicebox.getValue());
                //TimeUnit.SECONDS.sleep(1);
                loadCreateEvent();
                break;
            default:
                System.out.println("YOU'VE BETTER LEARN HOW TO USE JFX!");
        }
    }

    @FXML
    private void goToMainMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/mainMenu.fxml"));
        BorderPane pane = loader.load();
        eventsPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToProfile(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/profile.fxml"));
        BorderPane pane = loader.load();
        eventsPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToFriends(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/friendsPage.fxml"));
        loader.setLocation(getClass().getResource("/resources/friendsPage.fxml"));
        BorderPane pane = loader.load();
        eventsPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToChat(ActionEvent event) throws IOException {
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

    private void loadDiscover() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/discover.fxml"));
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

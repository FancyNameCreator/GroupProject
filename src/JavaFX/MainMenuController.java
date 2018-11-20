package JavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainMenuController {

    public AnchorPane getMainPane() {
        return mainPane;
    }

    @FXML
    private AnchorPane mainPane;

    @FXML
    private void goToProfile(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/profile.fxml"));
        BorderPane pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToEvents(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/eventsPage.fxml"));
        BorderPane pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToFriends(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/friendsPage.fxml"));
        AnchorPane pane = loader.load();

        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToChat(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/profilePage.fxml"));
        AnchorPane pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }
}

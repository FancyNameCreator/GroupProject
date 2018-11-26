package JavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class FriendsPageController {
    @FXML
    private BorderPane friendsPane;

    @FXML
    private void AddNewOne (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/addFriends.fxml"));
        BorderPane pane = loader.load();
        friendsPane.getChildren().setAll(pane);
    }

    @FXML
    private void BackToFriendsList (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/friendsPage.fxml"));
        BorderPane pane = loader.load();
        friendsPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToProfile(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/profile.fxml"));
        BorderPane pane = loader.load();
        friendsPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToEvents(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/eventsPage.fxml"));
        BorderPane pane = loader.load();
        friendsPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToMainMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/mainMenu.fxml"));
        loader.setLocation(getClass().getResource("/resources/mainMenu.fxml"));
        BorderPane pane = loader.load();
        friendsPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToChat(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/profilePage.fxml"));
        BorderPane pane = loader.load();
        friendsPane.getChildren().setAll(pane);
    }
}

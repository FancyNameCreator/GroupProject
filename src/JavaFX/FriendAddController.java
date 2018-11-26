package JavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class FriendAddController {

    @FXML
    private BorderPane friendsPane;

    @FXML
    private void BackToFriendsList (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/friendsPage.fxml"));
        BorderPane pane = loader.load();
        friendsPane.getChildren().setAll(pane);
    }

}

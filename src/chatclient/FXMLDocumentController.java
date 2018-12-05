package chatclient;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import JavaFX.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class FXMLDocumentController {
    private ChatGateway gateway;
    @FXML
    private TextArea textArea;
    @FXML
    public TextField comment;
    @FXML
    private BorderPane chatPane;

    @FXML
    public void initialize() {
        gateway = new ChatGateway(textArea);
        gateway.sendHandle(getHandle());

        // Start the transcript check thread
        new Thread(new TranscriptCheck(gateway, textArea)).start();
    }

    @FXML
    private void sendComment() {
        String text = comment.getText();
        gateway.sendComment(text);
        comment.setText("");
    }

    static String getHandle() {
        String handle = "default";

        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from users where email = '" + Main.getEmailIN() + "'");

            // 4. Process the result set
            while (myResults.next()) {
                String firstName = myResults.getString("first_name");
                String lastName = myResults.getString("last_name");
                handle = firstName + "_" + lastName;
            }

        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        return handle;
    }

    //  this method allows logging in also by clicking ENTER button
    @FXML
    private void actOnEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {   //  checks whether key code that user clicked is same as this of enter
            sendComment();
        }
    }


    @FXML
    private void goToMainMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/mainMenu.fxml"));
        BorderPane pane = loader.load();
        chatPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToProfile(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/profile.fxml"));
        BorderPane pane = loader.load();
        chatPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToFriends(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/friendsPage.fxml"));
        loader.setLocation(getClass().getResource("/resources/friendsPage.fxml"));
        BorderPane pane = loader.load();
        chatPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToEvents(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/eventsPage.fxml"));
        BorderPane pane = loader.load();
        chatPane.getChildren().setAll(pane);
    }
}


class TranscriptCheck implements Runnable, chat.ChatConstants {
    private ChatGateway gateway; // Gateway to the server
    private TextArea textArea; // Where to display comments
    private int N; // How many comments we have read

    /**
     * Construct a thread
     */
    public TranscriptCheck(ChatGateway gateway, TextArea textArea) {
        this.gateway = gateway;
        this.textArea = textArea;
        this.N = 0;
    }

    /**
     * Run a thread
     */
    public void run() {
        while (true) {
            if (gateway.getCommentCount() > N) {
                String newComment = gateway.getComment(N);
              /*String checking = "";
              StringBuilder sb = new StringBuilder(checking);
              int i = 0;

              for (;!(newComment.charAt(i) == '>'); i++){

              }
              for (; !(newComment.charAt(i+1) == '#'); i++) {
                  sb.append(newComment.charAt(i));
              }

              if (sb.toString().equals("To " + FXMLDocumentController.getHandle())) {*/
                Platform.runLater(() -> textArea.appendText(newComment + "\n"));
                //}

                N++;
            } else {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException ex) {
                }
            }
        }
    }
}
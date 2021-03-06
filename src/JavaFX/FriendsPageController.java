package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;

public class FriendsPageController {

    private ObservableList<Person> tableOfFriends = FXCollections.observableArrayList();

    public Person personSelected;

    @FXML
    private BorderPane friendsPane;

    @FXML
    private TableView<Person> tableViewList;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private TableColumn<Person, String> cityColumn;
    @FXML
    private TableColumn<Person, String> DOBColumn;

    @FXML
    private void initialize() {
        if (doUserHasFriends()) {
            loadTableOfFriends();
            firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
            DOBColumn.setCellValueFactory(new PropertyValueFactory<>("DoB"));
            tableViewList.setItems(tableOfFriends);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("You have no friends to show :(");
            alert.showAndWait();
        }
    }

    //  checks if user has friends
    private boolean doUserHasFriends() {
        String listOfFriends = "none";

        try {
            //  Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select friends from users where email = '" + Main.getEmailIN() + "'");

            //  Process the result set
            while (myResults.next()) {
                listOfFriends = myResults.getString("friends");
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (listOfFriends == null || listOfFriends.equals(""))
            return false;
        else
            return true;
    }

    //  load string of IDs of a user's friends and return it
    private String getStringOfFriends() {
        String listOfFriends = "none";

        try {
            //  Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select friends from users where email = '" + Main.getEmailIN() + "'");

            //  Process the result set
            while (myResults.next()) {
                listOfFriends = myResults.getString("friends");
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
        return listOfFriends;
    }

    //  loads table of user's friends
    private void loadTableOfFriends() {
        String friendsString = getStringOfFriends();

        try {
            //  Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from users where id in " + friendsString);

            //  Process the result set
            while (myResults.next()) {
                String id = myResults.getString("id");
                String firstName = myResults.getString("first_name");
                String lastName = myResults.getString("last_name");
                String email = myResults.getString("email");
                String password = myResults.getString("password");
                String city = myResults.getString("city");
                String DoB = myResults.getString("DoB");
                String eventsAttending = myResults.getString("events_attending");
                String friends = myResults.getString("friends");
                tableOfFriends.add(new Person(id, firstName, lastName, email, password, city, DoB, eventsAttending, friends));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    // refresh the table of friends
    @FXML
    private void refresh() {
        tableViewList.getItems().clear();
        if (doUserHasFriends()) {
            loadTableOfFriends();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("You have no friends to show :(");
            alert.showAndWait();
        }
    }


    /*
    ---------------------------------------------------------------------------------
    LOADERS METHODS - methods that load new scenes/stages
    ---------------------------------------------------------------------------------
    */

    @FXML
    private void showDetailsOfFriend() throws IOException {
        Main.chosenOne = tableViewList.getSelectionModel().getSelectedItem();

        //LOADING ENTIRELY NEW WINDOW:
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/resources/friendRemove.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        Stage stage = new Stage();
        stage.setTitle("Detail of your friend");
        stage.setScene(scene);
        stage.show();
        Image icon = new Image("/resources/Hanger Logo Done.png");
        stage.getIcons().add(icon);

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resources/friendsPage.fxml"));
            BorderPane pane = loader.load();
            friendsPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addNewOne() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/addFriends.fxml"));
        BorderPane pane = loader.load();
        friendsPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToProfile() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/profile.fxml"));
        BorderPane pane = loader.load();
        friendsPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToEvents() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/eventsPage.fxml"));
        BorderPane pane = loader.load();
        friendsPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToMainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/mainMenu.fxml"));
        loader.setLocation(getClass().getResource("/resources/mainMenu.fxml"));
        BorderPane pane = loader.load();
        friendsPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToChat() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/chatclient/FXMLDocument.fxml"));
        BorderPane pane = loader.load();
        friendsPane.getChildren().setAll(pane);
    }

}

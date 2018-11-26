package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.ResultSet;

public class FriendsPageController{

    private ObservableList<Person> tableOfFriends = FXCollections.observableArrayList();

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
    private void initialize(){
        if (/*you have friends*/ doUserHasFriends()){
            /*load table of friends*/
            loadTableOfFriends();
            firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
            DOBColumn.setCellValueFactory(new PropertyValueFactory<>("DoB"));
            tableViewList.setItems(tableOfFriends);
        }else{
            /*load sth else*/
            System.out.println("You are madafaka with no friends");
        }
    }

    private boolean doUserHasFriends(){
        String listOfFriends="none";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select friends from users where email = '"+ Main.getEmailIN() +"'");

            // 4. Process the result set
            while (myResults.next()) {
                listOfFriends = myResults.getString("friends");
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }

        if (listOfFriends == null || listOfFriends=="none")
            return false;
        else
            return true;
    }

    private String getStringOfFriends(){
        String listOfFriends = "none";

        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select friends from users where email = '"+ Main.getEmailIN() +"'");

            // 4. Process the result set
            while (myResults.next()) {
                listOfFriends = myResults.getString("friends");
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
        return listOfFriends;
    }

    private void loadTableOfFriends(){
        String friendsString = getStringOfFriends();

        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from users where id in " + friendsString);

            // 4. Process the result set
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

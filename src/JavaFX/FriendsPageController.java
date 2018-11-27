package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;

public class FriendsPageController{

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
    private void refresh() {
        tableViewList.getItems().clear();
        loadTableOfFriends();
    }

    @FXML
    private void addNewOne (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/addFriends.fxml"));
        BorderPane pane = loader.load();
        friendsPane.getChildren().setAll(pane);

    }

    @FXML
    private void showDetailsOfFriend() throws IOException{
        Main.chosenOne = tableViewList.getSelectionModel().getSelectedItem();

        /*
        JUST LOADING A NEW PANE:
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/friendRemove.fxml"));
        BorderPane pane = loader.load();
        friendsPane.getChildren().setAll(pane);
        */

        //LOADING ENTIRELY NEW WINDOW:
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/resources/friendRemove.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        Stage stage = new Stage();
        stage.setTitle("Detail of your friend");
        stage.setScene(scene);
        stage.show();
        Image icon = new Image("Hanger Logo Done.png");
        stage.getIcons().add(icon);

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resources/friendsPage.fxml"));
            BorderPane pane = loader.load();
            friendsPane.getChildren().setAll(pane);
        }catch(IOException e){
            e.printStackTrace();
        }
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

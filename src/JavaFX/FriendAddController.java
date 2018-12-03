package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;

/**
 * class responsible for searching for new friends, controller of addFriend.fxml
 */
public class FriendAddController {
    private ObservableList<Person> tableOfSearched = FXCollections.observableArrayList();

    @FXML
    private BorderPane friendsPane;

    @FXML
    private TextField textfieldSearch;

    @FXML
    private TableView<Person> tableViewSearch;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private TableColumn<Person, String> cityColumn;
    @FXML
    private TableColumn<Person, String> DOBColumn;

    //  set and initialize all scene items
    @FXML
    private void initialize(){
            firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
            DOBColumn.setCellValueFactory(new PropertyValueFactory<>("DoB"));
            tableViewSearch.setItems(tableOfSearched);
        }


    //  show details of a person in entirely new stage
    @FXML
    private void showDetailsOfFriend() throws IOException{
        Main.chosenOne = tableViewSearch.getSelectionModel().getSelectedItem();

        //LOADING ENTIRELY NEW WINDOW:
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/resources/friendsAdd.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        Stage stage = new Stage();
        stage.setTitle("Detail of person you may add");
        stage.setScene(scene);
        stage.show();
        Image icon = new Image("/resources/Hanger Logo Done.png");
        stage.getIcons().add(icon);
    }


//IT'S NOT USED BUT LETS LEAVE IT FOR A WHILE, MAYBE WE WILL USE IT AGAIN SOME DAY
//    @FXML
//    private void displayResults(){
//        tableViewSearch.getItems().clear();
//        String phrase = textfieldSearch.getText();
//
//        try {
//            // 3. Execute SQL query
//            ResultSet myResults = Main.stmt.executeQuery("select * from users where (first_name = '"+phrase+"' || last_name = '"+phrase+"' || city = '"+phrase+"')");
//
//            // 4. Process the result set
//            while (myResults.next()) {
//                String id = myResults.getString("id");
//                String firstName = myResults.getString("first_name");
//                String lastName = myResults.getString("last_name");
//                String email = myResults.getString("email");
//                String password = myResults.getString("password");
//                String city = myResults.getString("city");
//                String DoB = myResults.getString("DoB");
//                String eventsAttending = myResults.getString("events_attending");
//                String friends = myResults.getString("friends");
//
//                tableOfSearched.add(new Person(id, firstName, lastName, email, password, city, DoB, eventsAttending, friends));
//            }
//        } catch (Exception exc) {    //catch the exception if occurs
//            exc.printStackTrace();
//        }
//    }
/*

    @FXML
    private void actOnEnter(KeyEvent event){
        if(event.getCode() == KeyCode.ENTER)
                displayResults();
    }

*/

    //  display in a table all results that first names, last names or cities matches phrase that was entered
    @FXML
    private void searchWithHint(){

        tableViewSearch.getItems().clear();
        String phraseToSearch = textfieldSearch.getText();

        try {
            // 3. Execute SQL query
            String query = ("select * from users where (first_name like " + "'%" + phraseToSearch + "%' or last_name like "  + "'%" + phraseToSearch + "%' or city like " + "'%" + phraseToSearch + "%')");
            ResultSet myResults = Main.stmt.executeQuery(query);

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

                tableOfSearched.add(new Person(id, firstName, lastName, email, password, city, DoB, eventsAttending, friends));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML
    private void BackToFriendsList (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/friendsPage.fxml"));
        BorderPane pane = loader.load();
        friendsPane.getChildren().setAll(pane);
    }

}

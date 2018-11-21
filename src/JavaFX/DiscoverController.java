package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class DiscoverController {
    private ObservableList<String> usersChoice = FXCollections.observableArrayList(
            "Food event","Clubbing","Music event","Just meeting","Sport match","Hobby event");

    @FXML private BorderPane borderPaneDiscover;

    @FXML private ChoiceBox<String> choiceBoxDiscover;

    @FXML private TableView<Event> tableViewDiscover;

    @FXML private TableColumn<Event, String> eventNameColumnDiscover;

    @FXML private TableColumn<Event, String> eventLocationColumnDiscover;

    @FXML private TableColumn<Event, String> eventDateColumnDiscover;

    @FXML private TableColumn<Event, String> eventCategoryColumnCategory;

    @FXML private TableColumn<Event, String> eventCreatorColumnDiscover;

    @FXML
    private Button buttonGo;

    @FXML
    private void showTableDiscover(){
        switch (choiceBoxDiscover.getValue()) {
            case ("Food event"):
                loadFoodEvents();
                break;
            case ("Clubbing") :
                loadClubbingEvents();
                break;
            case ("Music event") :
                loadMusicEvents();
                break;
            case ("Just meeting") :
                loadMeetingsEvents();
                break;
            case ("Sport match") :
                loadSportsEvents();
                break;
            case ("Hobby event") :
                loadHobbyEvents();
                break;
            default:
                System.out.println("YOU'VE BETTER LEARN HOW TO USE JFX!");
        }
    }

    private void loadFoodEvents(){

    }

    private void loadClubbingEvents(){

    }

    private void loadMusicEvents(){

    }

    private void loadMeetingsEvents(){

    }

    private void loadSportsEvents(){

    }

    private void loadHobbyEvents(){

    }

}

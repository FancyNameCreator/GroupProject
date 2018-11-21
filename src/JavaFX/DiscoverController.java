package JavaFX;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class DiscoverController {

    @FXML
    private BorderPane borderPaneDiscover;

    @FXML
    private ChoiceBox<?> choiceBoxDiscover;

    @FXML
    private TableView<?> tableViewDiscover;

    @FXML
    private TableColumn<?, ?> eventNameColumnDiscover;

    @FXML
    private TableColumn<?, ?> eventLocationColumnDiscover;

    @FXML
    private TableColumn<?, ?> eventDateColumnDiscover;

    @FXML
    private TableColumn<?, ?> eventCategoryColumnCategory;

    @FXML
    private TableColumn<?, ?> eventCreatorColumnDiscover;

    @FXML
    private Button buttonGo;

}

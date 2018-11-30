package JavaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainMenuController {

    private ObservableList<String> year = FXCollections.observableArrayList("2019", "2020", "2021", "2022");
    private ObservableList<String> month = FXCollections.observableArrayList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
    private ObservableList<Event> events = FXCollections.observableArrayList();

    @FXML
    public void initialize () {
        chooseYear.setItems(year);
        chooseMonth.setItems(month);
        eventName.setCellValueFactory(new PropertyValueFactory<>("name"));
        eventCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        tableView.setItems(events);

    }

    @FXML
    public void choiceYear () throws IOException {
        chooseMonth.setDisable(false);
        buttonMonthConfirm.setDisable(false);

    }

    @FXML
    public void choiceMonth () throws IOException {
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        button6.setDisable(false);
        button7.setDisable(false);
        button8.setDisable(false);
        button9.setDisable(false);
        button10.setDisable(false);
        button11.setDisable(false);
        button12.setDisable(false);
        button13.setDisable(false);
        button14.setDisable(false);
        button15.setDisable(false);
        button16.setDisable(false);
        button17.setDisable(false);
        button18.setDisable(false);
        button19.setDisable(false);
        button20.setDisable(false);
        button21.setDisable(false);
        button22.setDisable(false);
        button23.setDisable(false);
        button24.setDisable(false);
        button25.setDisable(false);
        button26.setDisable(false);
        button27.setDisable(false);
        button28.setDisable(false);
        if (chooseYear.getValue().equals("2020")) {
            button29.setDisable(true);
            button30.setDisable(true);
            button31.setDisable(true);
            switch (chooseMonth.getValue()) {
                case ("02"):
                    button29.setDisable(false);
                    break;
                case ("04") : case ("06") : case ("09") : case ("11"):
                    button29.setDisable(false);
                    button30.setDisable(false);
                    break;
                default:
                    button29.setDisable(false);
                    button30.setDisable(false);
                    button31.setDisable(false);
                    break;
            }
        }
        else {
            button29.setDisable(true);
            button30.setDisable(true);
            button31.setDisable(true);
            switch (chooseMonth.getValue()) {
                case ("02"):
                    button29.setDisable(true);
                    break;
                case ("04") : case ("06") : case ("09") : case ("11"):
                    button29.setDisable(false);
                    button30.setDisable(false);
                    break;
                default:
                    button29.setDisable(false);
                    button30.setDisable(false);
                    button31.setDisable(false);
                    break;
            }

        }

    }
    @FXML private void chosenButton1 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-01";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton2 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-02";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton3 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-03";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton4 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-04";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton5 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-05";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton6 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-06";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton7 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-07";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton8 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-08";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton9 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-09";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton10 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-10";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton11 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-11";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton12 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-12";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton13 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-13";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton14 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-14";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton15 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-15";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton16 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-16";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton17 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-17";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton18 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-18";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton19 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-19";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton20 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-20";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton21 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-21";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton22 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-22";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton23 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-23";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton24 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-24";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton25 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-25";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton26 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-26";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton27 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-27";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton28 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-28";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton29 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-29";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton30 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-30";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private void chosenButton31 () throws IOException {
        tableView.getItems().clear();
        String y = chooseYear.getValue();
        String m = chooseMonth.getValue();
        String fullDate = y + "-" + m + "-31";
        try {
            // 3. Execute SQL query
            ResultSet myResults = Main.stmt.executeQuery("select * from events where event_date = '"+fullDate+"' ");

            // 4. Process the result set
            while (myResults.next()) {
                String ID = myResults.getString("event_id");
                String name = myResults.getString("event_name");
                String date = myResults.getString("event_date");
                String location = myResults.getString("event_location");
                String description = myResults.getString("event_description");
                String category = myResults.getString("event_category");
                String participants = myResults.getString("participants");
                String creator = myResults.getString("creator");
                events.add(new Event(ID,name,date,location,description,category,participants,creator));
            }
        } catch (Exception exc) {    //catch the exception if occurs
            exc.printStackTrace();
        }
    }

    @FXML private BorderPane mainPane;

    @FXML private ChoiceBox <String> chooseYear;

    @FXML private ChoiceBox <String> chooseMonth;

    @FXML private Button buttonYearConfirm;

    @FXML private Button buttonMonthConfirm;

    @FXML private TableView<Event> tableView;

    @FXML private TableColumn<Event, String> eventName;

    @FXML private TableColumn<Event, String> eventCategory;

    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private Button button3;
    @FXML private Button button4;
    @FXML private Button button5;
    @FXML private Button button6;
    @FXML private Button button7;
    @FXML private Button button8;
    @FXML private Button button9;
    @FXML private Button button10;
    @FXML private Button button11;
    @FXML private Button button12;
    @FXML private Button button13;
    @FXML private Button button14;
    @FXML private Button button15;
    @FXML private Button button16;
    @FXML private Button button17;
    @FXML private Button button18;
    @FXML private Button button19;
    @FXML private Button button20;
    @FXML private Button button21;
    @FXML private Button button22;
    @FXML private Button button23;
    @FXML private Button button24;
    @FXML private Button button25;
    @FXML private Button button26;
    @FXML private Button button27;
    @FXML private Button button28;
    @FXML private Button button29;
    @FXML private Button button30;
    @FXML private Button button31;



    @FXML
    private void goToProfile(ActionEvent actionEvent) throws IOException {
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/friendsPage.fxml"));
        loader.setLocation(getClass().getResource("/resources/friendsPage.fxml"));
        BorderPane pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void goToChat(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/chatclient/FXMLDocument.fxml"));
        BorderPane pane = loader.load();
        mainPane.getChildren().setAll(pane);
    }
}

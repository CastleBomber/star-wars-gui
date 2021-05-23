package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class ReadOptionsController implements Initializable {

    @FXML
    private TextField screen1;
    @FXML
    private TextField screen2;
    @FXML
    private TextField screen3;
    @FXML
    private TextField screen4;
    @FXML
    private TextField screen5;
    @FXML
    private Button closeButton;
    @FXML
    private Button goBackButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    public void usernameMenuItemOnAction(ActionEvent event){
        //screen.setText("people");

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String query = "select * from user_account";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);

            boolean loop = true;
            while(loop) {
                if (queryResult.next()) {
                    screen1.setText(queryResult.getString("username"));
                } else {
                    loop = false;
                    break;
                }
                if (queryResult.next()) {
                    screen2.setText(queryResult.getString("username"));
                } else {
                    loop = false;
                    break;
                }
                if (queryResult.next()) {
                    screen3.setText(queryResult.getString("username"));
                } else {
                    loop = false;
                    break;
                }
                if (queryResult.next()) {
                    screen4.setText(queryResult.getString("username"));
                } else {
                    loop = false;
                    break;
                }
                if (queryResult.next()) {
                    screen5.setText(queryResult.getString("username"));
                } else {
                    loop = false;
                    break;
                }
            }
            queryResult.close();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void peopleMenuItemOnAction(ActionEvent event){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String query = "select * from PEOPLE";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);

            boolean loop = true;
            while(loop) {
                if (queryResult.next()) {
                    screen1.setText(queryResult.getString("people_name"));
                } else {
                    loop = false;
                    break;
                }
                if (queryResult.next()) {
                    screen2.setText(queryResult.getString("people_name"));
                } else {
                    loop = false;
                    break;
                }
                if (queryResult.next()) {
                    screen3.setText(queryResult.getString("people_name"));
                } else {
                    loop = false;
                    break;
                }
                if (queryResult.next()) {
                    screen4.setText(queryResult.getString("people_name"));
                } else {
                    loop = false;
                    break;
                }
                if (queryResult.next()) {
                    screen5.setText(queryResult.getString("people_name"));
                } else {
                    loop = false;
                    break;
                }
            }
            queryResult.close();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void planetsMenuItemOnAction(ActionEvent event){
        screen1.setText("planets");
    }

    public void speciesMenuItemOnAction(ActionEvent event){
        screen1.setText("species");
    }

    public void goBackButtonOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CRUDoptions.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 520, 567));
            registerStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }
}

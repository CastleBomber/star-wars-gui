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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class ReadOptionsController implements Initializable {

    @FXML
    private TextField screen;
    @FXML
    private Button closeButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    public void peopleMenuItemOnAction(ActionEvent event){
        //screen.setText("people");

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String query = "select * from user_account";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            queryResult.next();
            screen.setText(queryResult.getString("username"));

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void planetsMenuItemOnAction(ActionEvent event){
        screen.setText("planets");
    }

    public void speciesMenuItemOnAction(ActionEvent event){
        screen.setText("species");
    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }
}

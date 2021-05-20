package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;


public class CreateOptionsController implements  Initializable{
    @FXML
    private Button closeButton;
    @FXML
    private Button useraccountButton;
    @FXML
    private Button peopleButton;
    @FXML
    private Button starshipsButton;
    @FXML
    private Button speciesButton;
    @FXML
    private Button weaponsButton;
    @FXML
    private Button planetsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    public void useraccountButtonOnAction(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 520, 567));
            registerStage.show();

        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void peopleButtonOnAction(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("createPeople.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 520, 567));
            registerStage.show();

        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void planetsButtonOnAction(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("createPlanets.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 520, 567));
            registerStage.show();

        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void speciesButtonOnAction(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("createSpecies.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 520, 567));
            registerStage.show();

        } catch(Exception e){
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

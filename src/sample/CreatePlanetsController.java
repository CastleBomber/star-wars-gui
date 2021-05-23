package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.DatabaseConnection;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CreatePlanetsController implements Initializable {
    @FXML
    private Button closeButton;
    @FXML
    private Button registerButton;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField rotationPeriodTextField;
    @FXML
    private TextField orbitalPeriodTextField;
    @FXML
    private TextField diameterTextField;
    @FXML
    private TextField climateTextField;
    @FXML
    private TextField gravityTextField;
    @FXML
    private TextField terrainTextField;
    @FXML
    private TextField surfaceWaterTextField;
    @FXML
    private TextField populationTextField;
    @FXML
    private TextField filmsTextField;

    public void initialize(URL url, ResourceBundle resourceBundle){
    }

    public void registerButtonOnAction(ActionEvent event){
        registerPlanet();
    }

    public void registerPlanet(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String name = nameTextField.getText();
        String rotation = rotationPeriodTextField.getText();
        String orbital = orbitalPeriodTextField.getText();
        String diameter = diameterTextField.getText();
        String climate = climateTextField.getText();
        String gravity = gravityTextField.getText();
        String terrain = terrainTextField.getText();
        String surfaceWater = surfaceWaterTextField.getText();
        String population = populationTextField.getText();
        String films = filmsTextField.getText();

        @SuppressWarnings("SqlResolve") String insertFields = "insert into PLANETS(planets_name, planets_rotation_period, planets_orbital_period, planets_diameter, planets_climate, planets_gravity, planets_terrain, planets_surface_water, planets_population, planets_films) values ('";
        String insertValues = name + "','" + rotation + "','" + orbital + "','" + diameter + "','" + climate + "','" + gravity + "','" + terrain + "','" + surfaceWater + "','" + population + "','" + films +  "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            registrationMessageLabel.setText("User has been registered successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void goBackButtonOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("createOptions.fxml"));
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

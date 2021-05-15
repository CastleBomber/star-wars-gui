// In edit configurations
// VM options: --module-path ${PATH_TO_FX} --add-modules=javafx.controls,javafx.fxml
// but can't have both

module Star.Wars.GUI {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;

    opens sample;
}
module com.example.atividadeavaliativa3010 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.atividadeavaliativa3010 to javafx.fxml;
    exports com.example.atividadeavaliativa3010;
}
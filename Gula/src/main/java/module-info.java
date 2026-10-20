module com.example.gula {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gula to javafx.fxml;
    exports com.example.gula;
}
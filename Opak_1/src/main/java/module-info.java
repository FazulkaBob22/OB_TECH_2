module com.example.opak_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.opak_1 to javafx.fxml;
    exports com.example.opak_1;
}
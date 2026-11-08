module com.example.opak_3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.opak_3 to javafx.fxml;
    exports com.example.opak_3;
}
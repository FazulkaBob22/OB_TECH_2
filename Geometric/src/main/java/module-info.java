module com.example.geometric {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.geometric to javafx.fxml;
    exports com.example.geometric;
}
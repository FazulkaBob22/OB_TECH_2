module com.example.auticko {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.auticko to javafx.fxml;
    exports com.example.auticko;
}
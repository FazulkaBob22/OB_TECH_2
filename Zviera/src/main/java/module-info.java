module com.example.zviera {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zviera to javafx.fxml;
    exports com.example.zviera;
}
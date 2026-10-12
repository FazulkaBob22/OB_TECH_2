module com.example.robot_chod {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.robot_chod to javafx.fxml;
    exports com.example.robot_chod;
}
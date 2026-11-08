module com.example.s6_z1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.s6_z1 to javafx.fxml;
    exports com.example.s6_z1;
}
module com.example.ot_s3_semafor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ot_s3_semafor to javafx.fxml;
    exports com.example.ot_s3_semafor;
}
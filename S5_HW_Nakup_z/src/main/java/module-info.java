module com.example.s5_hw_nakup_z {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.s5_hw_nakup_z to javafx.fxml;
    exports com.example.s5_hw_nakup_z;
}
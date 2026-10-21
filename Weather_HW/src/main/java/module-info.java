module com.example.weather_hw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.weather_hw to javafx.fxml;
    exports com.example.weather_hw;
}
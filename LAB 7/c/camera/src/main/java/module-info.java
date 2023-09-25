module com.example.camera {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.camera to javafx.fxml;
    exports com.example.camera;
}
module com.example.kasirajatest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kasirajatest to javafx.fxml;
    exports com.example.kasirajatest;
}
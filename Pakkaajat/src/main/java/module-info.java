module testi.pakkaajat {
    requires javafx.controls;
    requires javafx.fxml;

    opens testi.pakkaajat to javafx.fxml;
    exports testi.pakkaajat;
}
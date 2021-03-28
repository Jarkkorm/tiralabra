module pakkaajat {
    requires javafx.controls;
    requires javafx.fxml;

    opens pakkaajat to javafx.fxml;
    exports pakkaajat;
}
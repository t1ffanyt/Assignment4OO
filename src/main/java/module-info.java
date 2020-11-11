module assign4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    opens assign4 to javafx.fxml;
    exports assign4;
    //exports main to javafx.graphics;

}

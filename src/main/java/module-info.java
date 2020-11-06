module assign4 {
    requires javafx.controls;
    requires javafx.fxml;
    opens assign4 to javafx.fxml;
    exports assign4;
    //exports main to javafx.graphics;

}

package assign4;

import java.io.IOException;
import javafx.fxml.FXML;

public class TeamListView {

    @FXML
    private void switchToSecondary() throws IOException {
        Main.setRoot("secondary");
    }
}

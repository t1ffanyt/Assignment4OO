package assign4.view.teameditor;

import assign4.viewmodel.TeamEditorViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TeamEditorController {

    @FXML
    TextField teamNameField;

    @FXML
    TextField teamScoreField;

    private TeamEditorViewModel viewModel;

    public TeamEditorController() {
    }

    public void init(TeamEditorViewModel teamEditorViewModel) {
        this.viewModel = teamEditorViewModel;


    }

    public void onUpdateButton(ActionEvent actionEvent) {
        viewModel.updateListView();
    }
}

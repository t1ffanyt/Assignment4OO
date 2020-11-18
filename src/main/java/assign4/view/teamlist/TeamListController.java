package assign4.view.teamlist;

import assign4.viewmodel.TeamListViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TeamListController {

    @FXML
    ListView listOfTeams;

    private TeamListViewModel viewModel;

    public void init(TeamListViewModel teamListViewModel) {
    }
}

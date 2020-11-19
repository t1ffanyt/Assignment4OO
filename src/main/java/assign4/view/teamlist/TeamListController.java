package assign4.view.teamlist;

import assign4.model.Team;
import assign4.viewmodel.TeamListViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TeamListController implements Initializable {

    @FXML
    ListView listOfTeams;

    private TeamListViewModel teamListViewModel;


    public TeamListController(ArrayList<Team> teams){
        this.teamListViewModel = new TeamListViewModel(teams);
    }


    public void init(TeamListViewModel teamListViewModel) {
        this.listOfTeams.accessibleTextProperty().bindBidirectional(teamListViewModel.listProperty());
    }

    @FXML
    private void onDoubleClick(){
        this.teamListViewModel.openEditor();
    }

    public TeamListViewModel getTeamListVM(){
        return teamListViewModel;
    }

    public void setViewModel(TeamListViewModel viewModel) {
        this.teamListViewModel = viewModel;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

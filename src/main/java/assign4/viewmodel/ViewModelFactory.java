package assign4.viewmodel;

import assign4.model.Team;
import assign4.model.TeamFactory;

import java.util.ArrayList;

public class ViewModelFactory {

    private TeamListViewModel teamListViewModel;

    private TeamEditorViewModel teamEditorViewModel;

    public ViewModelFactory(TeamFactory teamFactory) {
        ArrayList<Team> teams = new ArrayList<>();
        //teamListViewModel = new TeamListViewModel(teamFactory.getTeam());
        teamEditorViewModel = new TeamEditorViewModel();
    }

    public TeamListViewModel getTeamListViewModel() {
        return teamListViewModel;
    }

    public TeamEditorViewModel getTeamEditorViewModel() {
        return teamEditorViewModel;
    }

}

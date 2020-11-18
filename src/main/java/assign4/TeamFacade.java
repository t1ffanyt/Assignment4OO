package assign4;

import assign4.model.Team;
import assign4.viewmodel.TeamEditorViewModel;
import assign4.viewmodel.TeamListViewModel;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class TeamFacade {
    private TeamEditorViewModel editorViewModel;
    private TeamListViewModel listViewModel;
    private FileHandler fileHandler;
    private Team currentTeam;

    public TeamFacade(){
        ArrayList<Team> listViewArr = new ArrayList<>();
        fileHandler = new FileHandler();
        try {
            listViewArr = fileHandler.readCsvFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        listViewModel = new TeamListViewModel(listViewArr);
        editorViewModel = new TeamEditorViewModel();
        currentTeam = new Team();

    }
    public void start(){
        Scene scene = new Scene((Parent)listViewModel);
        Stage stage = new Stage();
        stage.setTitle("CS 4773 Assignment 4");
        stage.setScene(scene);
        stage.show();
    }
    /**
    public void openTeamEditorWindow(Team team){
        Scene scene = new Scene((Parent)cellView);
        Stage stage = new Stage();
        stage.setTitle("Editing " + team.getTeamName());
        cellView.setTeamNameField(team.getTeamName());
        cellView.setLastUpdatedField(team.getLastModified().toString());
        cellView.setTeamScoreField(Integer.toString(team.getScore()));
        stage.setScene(scene);
        stage.show();

    }
     **/
}

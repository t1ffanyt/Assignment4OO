package assign4;

import assign4.Model.ListViewModel;
import assign4.Model.Team;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TeamFacade {

    private ListViewModel listView;
    private TeamListCellViewModel cellView;

    public TeamFacade(ArrayList<Team> teams){
        listView = new ListViewModel(teams);
        cellView = new TeamListCellViewModel();
    }
    public void start(){
        Scene scene = new Scene((Parent)listView);
        Stage stage = new Stage();
        stage.setTitle("CS 4773 Assignment 4");
        stage.setScene(scene);
        stage.show();
    }




}

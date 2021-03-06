package assign4;

import assign4.model.Team;
import assign4.view.teameditor.TeamEditorController;
import assign4.view.teamlist.TeamListController;
import assign4.viewmodel.TeamEditorViewModel;
import assign4.viewmodel.TeamListViewModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class TeamFacade {
    private TeamEditorViewModel editorViewModel;
    private TeamListViewModel teamListViewModel;
    private FileHandler fileHandler;
    private ArrayList<Team> teams;
    private Stage stage;

    public TeamFacade(Stage stage){
        teams = new ArrayList<>();
        this.stage = stage;
        fileHandler = new FileHandler();
        try {
            teams = fileHandler.readCsvFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openTeamListViewWindow(){
        TeamListController teamListController = new TeamListController(teams);
        teamListViewModel = new TeamListViewModel(teams);
        teamListController.setViewModel(teamListViewModel);
        Scene scene = new Scene((Parent) teamListViewModel);
        stage.setTitle("CS 4773 Assignment 4");
        stage.setScene(scene);
        stage.show();
    }

    public void openTeamEditorWindow(Team team) throws IOException{
        TeamEditorController teamEditorController = new TeamEditorController(team);
        editorViewModel = new TeamEditorViewModel(team);
        teamEditorController.setViewModel(editorViewModel);

        Scene scene = new Scene((Parent)editorViewModel);
        stage.setTitle("Editing " + team.getTeamName());
        editorViewModel.initialize(null,null);
        stage.setScene(scene);

        FXMLLoader fxmlLoader = new FXMLLoader();
        URL fxml = getClass().getResource("/TeamEditorView.fxml");
        fxmlLoader.setLocation(fxml);
        Parent root = fxmlLoader.load();
        stage.setScene(new Scene(root));
       // scene.setRoot(fxmlLoader.load());
        stage.show();

    }

}

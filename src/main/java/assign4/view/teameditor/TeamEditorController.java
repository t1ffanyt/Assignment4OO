package assign4.view.teameditor;
import assign4.model.Team;
import assign4.viewmodel.TeamEditorViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeamEditorController implements Initializable {

    private TeamEditorViewModel teamEditorViewModel;

    @FXML
    TextField teamNameField;

    @FXML
    TextField teamScoreField;

    private Parent parentNode;

    private Team currentTeam;

    public TeamEditorController(Team team) {
        this.currentTeam = team;
    }

    public void init(TeamEditorViewModel teamEditorViewModel) {
        this.teamEditorViewModel= teamEditorViewModel;
        this.currentTeam = teamEditorViewModel.getItem();
    }


    public void saveClicked(ActionEvent actionEvent) {
        try{
            teamEditorViewModel.save();
        }catch(RuntimeException e){
            System.out.println("Save Error" + e);
        }
    }
    public void setViewModel(TeamEditorViewModel viewModel){
        this.teamEditorViewModel = viewModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    public Parent getParentNode(){
        return parentNode;
    }

    public void setParentNode(Parent parentNode){
        this.parentNode = parentNode;
    }
}

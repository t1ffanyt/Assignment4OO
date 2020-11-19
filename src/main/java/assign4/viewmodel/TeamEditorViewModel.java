package assign4.viewmodel;

import assign4.model.Team;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TeamEditorViewModel extends ListCell<Team> implements Initializable {

    private Team team;

    @FXML
    private TextField teamNameField;

    @FXML
    private TextField teamScoreField;

    @FXML
    private TextField lastUpdatedField;

    @FXML
    private Button saveButton;

    public TeamEditorViewModel(Team team){
        this.team = team;

    }

    @Override
    protected void updateItem(Team team, boolean empty) {

    }

    // if name is longer than 50 chars then chop take left and append ... to it
    private String formatTeamName(String name) {
        if(name.length() > 50)
            return name.substring(0, 48) + "...";
        return name;
    }

    public void save() {
        team.setTeamName(teamNameField.getText());
        team.setScore(Integer.parseInt(teamScoreField.getText()));
        team.setLastModified();
        team.notifyObservers();
        team.save();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        teamNameField.setText(team.getTeamName());
        teamScoreField.setText(Integer.toString(team.getScore()));
        lastUpdatedField.setText(team.getLastModified().toString());
    }
}

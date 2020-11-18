package assign4;

import assign4.Model.Team;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import java.io.IOException;

/*
    this is the list cell (like a view model of an individual team row in the list view)
    mercilessly swiped from:
    https://www.turais.de/how-to-custom-listview-cell-in-javafx/
 */
public class TeamListCellViewModel extends ListCell<Team> {
    private static final String fxmlPath = "/assign4/TeamListView.fxml";

    // the cell will use an fxml loader to load its fxml the first time it is visible
    private FXMLLoader loader;

    @FXML
    private HBox hbox;

    @FXML
    private Button saveButton;

    @FXML
    private TextField teamNameField;


    @FXML
    private TextField teamScoreField;

    @FXML
    private TextField lastUpdatedField;



    // this is what we need to override for a custom list cell
    @Override
    protected void updateItem(Team team, boolean empty) {
        super.updateItem(team, empty);

        if(empty || team == null) {
            setText(null);
            setGraphic(null);
        } else {
            if(loader == null) {
                loader = new FXMLLoader(TeamListCellViewModel.class.getResource(fxmlPath));
                loader.setController(this);
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            teamNameField.setText(formatTeamName(team.getTeamName()));
            setText(null);
            setGraphic(hbox);
        }
    }

    // if name is longer than 50 chars then chop take left and append ... to it
    private String formatTeamName(String name) {
        if(name.length() > 50)
            return name.substring(0, 48) + "...";
        return name;
    }

    public TextField getTeamScoreField() {
        return teamScoreField;
    }

    public void setTeamScoreField(String teamScoreField) {
        this.teamScoreField.setText(teamScoreField);
    }

    public TextField getLastUpdatedField() {
        return lastUpdatedField;
    }

    public void setLastUpdatedField(String lastUpdatedField) {

        this.lastUpdatedField.setText(lastUpdatedField);
    }

    public TextField getTeamNameField() {
        return teamNameField;
    }

    public void setTeamNameField(String teamNameField) {
        this.teamNameField.setText(teamNameField);
    }
}

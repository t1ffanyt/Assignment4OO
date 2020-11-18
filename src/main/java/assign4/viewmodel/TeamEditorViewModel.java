package assign4.viewmodel;

import assign4.model.Team;
import javafx.scene.control.ListCell;

import java.util.ArrayList;

public class TeamEditorViewModel extends ListCell<Team> {

    private ArrayList<Team> teamArrayList;

    public TeamEditorViewModel(){
        teamArrayList = new ArrayList<>();
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
}

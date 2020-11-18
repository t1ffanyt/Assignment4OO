package assign4.model;

import assign4.viewmodel.TeamListViewModel;
import java.time.LocalDateTime;
import java.beans.*;

public class Team implements PropertyChangeListener {
    private String teamName;
    private int score;
    private LocalDateTime lastModified;

    public Team() {
        this.teamName = "No name provided";
        this.score = 0;
        this.lastModified = LocalDateTime.now();
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }

    public void addObserver(TeamListViewModel listViewModel) {

    }

    @Override
    public String toString() {
        String format = "%-" + Integer.toString(80-teamName.length()) + "s%d";
        return String.format(format, teamName, score);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = LocalDateTime.now();
    }

}

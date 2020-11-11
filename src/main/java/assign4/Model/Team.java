package assign4.Model;

import java.time.LocalDateTime;

public class Team {
    private String teamName;
    private int score;
    private LocalDateTime lastModified;

    public Team() {
        this.teamName = "No name provided";
        this.score = 0;
        this.lastModified = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", score=" + score +
                ", lastModified=" + lastModified +
                '}';
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
        this.lastModified = lastModified;
    }
}

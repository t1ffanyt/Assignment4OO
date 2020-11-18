package assign4.model;

public class TeamFactory {

    private Team team;

    public Team getTeam() {
        if (team == null) {
            team = new Team();
        }
        return team;
    }
}

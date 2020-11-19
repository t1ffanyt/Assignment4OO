package assign4.model;

import assign4.viewmodel.TeamListViewModel;
import java.time.LocalDateTime;
import java.beans.*;
import java.util.ArrayList;

public class Team {
    private String teamName;
    private int teamScore;
    private LocalDateTime lastModified;
    private ArrayList<PropertyChangeListener> observers;

    public Team(String teamName,int score) {
        this.setTeamName(teamName);
        this.setScore(score);
        this.setLastModified();
        this.observers = new ArrayList<>();
    }

    @Override
    public String toString() {
        String format = "%-" + (80-teamName.length()) + "s%d";
        return String.format(format, teamName, teamScore);
    }

    public void save() throws TeamException{
        System.out.println("Saved.");
    }
    public static boolean isValidTeamName(String teamName){
        if(teamName.length() < 5 || teamName.length() > 50) return false;
        if(!teamName.matches("[A-Za-z0-9]+")) return false;
        return true;
    }
    public static boolean isValidTeamScore(int score){
        if(score < 0 || score > 2000) return false;
        return true;
    }
    public void notifyObservers(){
        PropertyChangeEvent event = new PropertyChangeEvent(this,"teamName",this.teamName,this.teamName);
        for(PropertyChangeListener observer : observers){
            observer.propertyChange(event);
        }
    }
    public void addObserver(PropertyChangeListener observer) {
        observers.add(observer);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getScore() {
        return teamScore;
    }

    public void setScore(int score) {
        this.teamScore = score;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified() {
        this.lastModified = LocalDateTime.now();
    }

}

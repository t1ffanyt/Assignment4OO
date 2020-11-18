package assign4;

import assign4.Main;
import assign4.Model.Team;
import assign4.TeamListCellViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;

public class TeamListViewModel extends AnchorPane implements PropertyChangeListener {
    @FXML
    private ObservableList<Team> teamList;

    @FXML
    private ListView listView;


    public TeamListViewModel(ArrayList<Team> teams) {
        super();
        teamList = FXCollections.observableArrayList(teams);
        // list view model needs to register as an observer for all of our team models
        for (Team team: teams) {
            team.addObserver(this);
        }
        listView = new ListView();
        listView.setItems(teamList);

        listView.setMinWidth(600);
        listView.setPrefHeight(300);

        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                Parent root;
                if (click.getClickCount() == 2) {
                    if (listView.getSelectionModel().getSelectedItem() == null) return;
                    Team team = (Team) listView.getSelectionModel().getSelectedItem();
                    // Open new detail window with the selected model
                    TeamListCellViewModel listCellViewModel = new TeamListCellViewModel(team);
                    // root = FXMLLoader.load(getClass().getClassLoader().getResource("assign4/TeamEditorViewModel"),resources);
                    Stage stage = new Stage();
                    Scene scene = new Scene((Parent)listCellViewModel);
                    stage.setTitle("Editing " + team.getTeamName());
                    stage.setScene(scene);
                    try {
                        Main.setRoot("TeamEditorView",scene);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(team.getTeamName());


                    stage.show();
                    // Hide this current window (if this is what you want)
                    //((Node)(event.getSource())).getScene().getWindow().hide();


                    System.out.println("*** double click on " + team);
                }
            }
        });

        this.getChildren().add(listView);
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        listView.refresh();
    }
}

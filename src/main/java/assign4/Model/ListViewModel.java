package assign4.Model;

import assign4.TeamListCellViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ListViewModel extends AnchorPane implements PropertyChangeListener {

    private ObservableList<Team> teamList;

    private ListView listView;

    public ListViewModel(ArrayList<Team> teams) {
        super();
        teamList = FXCollections.observableArrayList(teams);

        // list view model needs to register as an observer for all of our team models
        for (Team team: teams) {
            team.addObserver(this);
        }

        listView = new ListView();
        listView.setItems(teamList);

        // teaching: give our list view a list cell instance to apply to all of its model data
        listView.setCellFactory((whoCares) -> new TeamListCellViewModel());

        listView.setMinWidth(600);
        listView.setPrefHeight(300);

        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    if (listView.getSelectionModel().getSelectedItem() == null) return;
                    Team selected = (Team) listView.getSelectionModel().getSelectedItem();
                    // Open new detail window with the selected model
                    System.out.println("*** double click on " + selected);
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
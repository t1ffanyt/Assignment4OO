package assign4.Model;

import assign4.Main;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;

public class ListViewModel extends AnchorPane implements PropertyChangeListener {

    private static final String fxmlPath = "assign4/TeamListView.fxml";

    @FXML
    private ObservableList<Team> teamList;

    @FXML
    private ListView listView;

    private FXMLLoader loader;

    private static Scene scene;


    public ListViewModel(ArrayList<Team> teams) {
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
                if (click.getClickCount() == 2) {
                    if (listView.getSelectionModel().getSelectedItem() == null) return;
                    Team selected = (Team) listView.getSelectionModel().getSelectedItem();
                    // Open new detail window with the selected model
                    try {
                        Main.setRoot("secondary");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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

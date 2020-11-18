package assign4.view;

import assign4.view.teameditor.TeamEditorController;
import assign4.view.teamlist.TeamListController;
import assign4.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.text.View;
import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private ViewModelFactory vmf;

    public ViewHandler(Stage stage, ViewModelFactory vmf) {
        this.stage = stage;
        this.vmf = vmf;
    }

    public void start() throws Exception {
        openView("TeamList");
    }

    public void openView(String viewToOpen) throws IOException {
        Scene scene;
        FXMLLoader loader = new FXMLLoader();
        Parent root;

        loader.setLocation(getClass().getResource(viewToOpen.toLowerCase()+"/"+viewToOpen+"View.fxml"));
        root = loader.load();

        if (viewToOpen.equals("TeamList")) {
            TeamListController view = loader.getController();
            view.init(vmf.getTeamListViewModel());
            stage.setTitle("CS 4773 Assignment 4");
        } else if (viewToOpen.equals("TeamEditor")) {
            TeamEditorController view = loader.getController();
            view.init(vmf.getTeamEditorViewModel());
            stage.setTitle("Editing ...");
        }

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

package assign4;

import assign4.Model.ListViewModel;
import assign4.Model.Team;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


/**
 * JavaFX App
 */
public class Main extends Application {

    TeamFacade facade = new TeamFacade();

    @Override
    public void start(Stage stage) throws IOException {
        facade.start();
    }
    public void startEditor(){
        facade.openTeamEditorWindow();
    }


    public static void setRoot(String fxml,Scene scene) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws IOException{
        launch();
    }


}
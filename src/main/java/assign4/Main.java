package assign4;

import assign4.Model.ListViewModel;
import assign4.Model.Team;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * JavaFX App
 */
public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        String row = "";
        String pathToCsv = "TeamData.csv";
        ArrayList<Team> listViewArr = new ArrayList<Team>();
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
        while ((row = csvReader.readLine()) != null) {
            String[] split = row.split(",");
            Team t = new Team();
            t.setScore(Integer.parseInt(split[1]));
            t.setTeamName(split[0]);
            listViewArr.add(t);
        }
        csvReader.close();
        TeamFacade facade = new TeamFacade(listViewArr);
        facade.start();

    }

    public static void setRoot(String fxml) throws IOException {
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
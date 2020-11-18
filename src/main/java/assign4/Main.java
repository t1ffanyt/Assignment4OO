package assign4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Random;

/**
 * JavaFX App
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        /*
        TeamFactory tf = new TeamFactory();
        ViewModelFactory vmf = new ViewModelFactory(tf);
        ViewHandler vh = new ViewHandler(stage, vmf);
        vh.start();
        runAutoUpdate((TeamModelManager) tf.getTeamModel());
         */

        TeamFacade facade = new TeamFacade();
        facade.start();
    }

    /*
    private void runAutoUpdate(TeamModelManager m) {
        Thread thread = new Thread(() -> {
            Random r = new Random();
            while (true) {
                m.recalculateData();
                try {
                    Thread.sleep(r.nextInt(500) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
    */


    public static void setRoot(String fxml,Scene scene) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws Exception {
        launch();
    }

}
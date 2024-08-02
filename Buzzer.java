import java.io.File;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Buzzer extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        File file = new File("./media/sounds/start.wav");
        String url = file.toURI().toString();
        System.out.println(url);

        // Media
        Media media = new Media(url);
        MediaPlayer player = new MediaPlayer(media);

        stage.show();

        player.play();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

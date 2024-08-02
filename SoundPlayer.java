import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundPlayer implements EventHandler<ActionEvent> {

    private MediaPlayer player;

    public SoundPlayer(String path){
        File file = new File(path);
        String url = file.toURI().toString();
        Media media = new Media(url);
        this.player = new MediaPlayer(media);
    }

    @Override
    public void handle(ActionEvent arg0) {
        player.stop();
        player.play();        
    }   
}

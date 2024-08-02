/**
 * A Channel class that creates channels to be played on a TV.
 * 
 * @author Owen Joslin (GCIS 124-08)
 */
package tv;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Channel {
    private String description;
    private String image;
    private String audio;
    private double volume;
    private MediaPlayer player;

    public Channel(String description, String image, String audio){
        this.description = description;
        this.image = image;
        this.audio = audio;
        this.volume = 0.5;

        // creates a new player for each channel
        File file = new File(this.audio);
        String url = file.toURI().toString();
        Media media = new Media(url);
        this.player = new MediaPlayer(media);
    }

    // increases player volume
    public void increaseVolume(){
        if(this.volume >= 1.0){
            this.volume = 1.0;
        }else{
            this.volume += 0.1;
        }
        this.player.setVolume(this.volume);
    }

    // decreased player volume
    public void decreaseVolume(){
        if(this.volume <= 0.0){
            this.volume = 0.0;
        }else{
            this.volume -= 0.1;
        }
        this.player.setVolume(this.volume);
    }

    // stops player
    public void stop(){
        this.player.stop();
    }

    // plays player
    public void play(){
        this.player.play();
    }

    // getters and setters
    public String getDescription(){
        return this.description;
    }

    public String getImage(){
        return this.image;
    }

    public String getAudio(){
        return this.audio;
    }

    public double getVolume(){
        return this.volume;
    }

    public void setVolume(double newVolume){
        this.volume = newVolume;
        this.player.setVolume(this.volume);
    }
}
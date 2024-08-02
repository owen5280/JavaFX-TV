/**
 * A CartoonsTV class that acts as a TV with a remote.
 * 
 * @author Owen Joslin (GCIS 124-08)
 */
package tv;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class CartoonsTV extends Application{
       
    private final String MEDIA_PATH = "./tv/media/";

    /**
     * Establishes the Channels
     */
    private Channel[] CHANNELS = {
        new Channel(
            "South Park", 
            MEDIA_PATH + "images/southpark.png",
            MEDIA_PATH + "audio/southpark.wav"
        ),
        new Channel(
            "Archer", 
            MEDIA_PATH + "images/archer.png",
            MEDIA_PATH + "audio/archer.wav"
        ),            
        new Channel(
            "Rick and Morty", 
            MEDIA_PATH + "images/rickandmorty.png",
            MEDIA_PATH + "audio/rickandmorty.wav"
        ),
        new Channel(
            "Regular Show", 
            MEDIA_PATH + "images/regularshow.png",
            MEDIA_PATH + "audio/regularshow.wav"
        ),
        new Channel(
            "SpongeBob SquarePants", 
            MEDIA_PATH + "images/spongebobsquarepants.png",
            MEDIA_PATH + "audio/spongebobsquarepants.wav"
        ),
        new Channel(
            "Invader Zim", 
            MEDIA_PATH + "images/invaderzim.png",
            MEDIA_PATH + "audio/invaderzim.wav"
        ),
        new Channel(
            "Teen Titans", 
            MEDIA_PATH + "images/teentitans.png",
            MEDIA_PATH + "audio/teentitans.wav"
        ),
        new Channel(
            "Invincible", 
            MEDIA_PATH + "images/invincible.png",
            MEDIA_PATH + "audio/invincible.wav"
        ),
        new Channel(
            "Adventure Time with Finn and Jake", 
            MEDIA_PATH + "images/adventuretime.png",
            MEDIA_PATH + "audio/adventuretime.wav"
        ),
        new Channel(
            "Avatar: The Last Airbender", 
            MEDIA_PATH + "images/avatarthelastairbender.png",
            MEDIA_PATH + "audio/avatarthelastairbender.wav"
        ),
    };

    /**
     * Variables that need to be accessed in helper functons
     */
    private static final int REMOTE_BUTTON_SIZE = 60;
    private Channel currentChannel = CHANNELS[0];
    private double curVolVal = 0.5;
    private Label curVoLabel;
    private ImageView screen;
    private Label description;

    @Override
    public void start(Stage stage) throws Exception {
                   
        VBox main = new VBox();

        // Channel 
        this.description = makeLabel(" " + 0 + " - " + this.currentChannel.getDescription(), Color.RED, Color.BLACK);

        // Image
        String imagelink = "file:" + this.currentChannel.getImage();
        Image image = new Image(imagelink);
        this.screen = new ImageView(image);
        this.screen.maxHeight(800);
        this.screen.maxWidth(450);

        // Remote Control Buttons
        String channelNunmberStyle = "-fx-background-color: grey; -fx-text-fill: black; -fx-font-size: 2em; -fx-border-color: black; -fx-border-width: 1px; -fx-font-size: 26; ";

        Button one = makeButton("1", channelNunmberStyle);
        Button two = makeButton("2", channelNunmberStyle);
        Button three = makeButton("3", channelNunmberStyle);
        Button four = makeButton("4", channelNunmberStyle);
        Button five = makeButton("5", channelNunmberStyle);
        Button six = makeButton("6", channelNunmberStyle);
        Button seven = makeButton("7", channelNunmberStyle);
        Button eight = makeButton("8", channelNunmberStyle);
        Button nine = makeButton("9", channelNunmberStyle);
        Button zero = makeButton("0", channelNunmberStyle);
        Button volDown = makeImageButton(channelNunmberStyle, new FileInputStream(MEDIA_PATH + "images/VolumeDown.png"));
        Button volUp = makeImageButton(channelNunmberStyle, new FileInputStream(MEDIA_PATH + "images/VolumeUp.png"));
        this.curVoLabel = makeLabel(String.valueOf((int)(curVolVal*10)), Color.RED, Color.BLACK);
        curVoLabel.setAlignment(Pos.CENTER);

        // Event handlers 
        one.setOnAction(e -> changeChannel(1));
        two.setOnAction(e -> changeChannel(2));
        three.setOnAction(e -> changeChannel(3));
        four.setOnAction(e -> changeChannel(4));
        five.setOnAction(e -> changeChannel(5));
        six.setOnAction(e -> changeChannel(6));
        seven.setOnAction(e -> changeChannel(7));
        eight.setOnAction(e -> changeChannel(8));
        nine.setOnAction(e -> changeChannel(9));
        zero.setOnAction(e -> changeChannel(0));
        volDown.setOnAction(e -> decreaseVol());
        volUp.setOnAction(e -> increaseVol());
        
        // GridPane
        GridPane grid = new GridPane();

        grid.add(description, 0, 1, 11, 1);
        grid.add(screen, 0, 2, 7, 6);
        grid.add(one, 8, 2);
        grid.add(two, 9, 2);
        grid.add(three, 10, 2);
        grid.add(four, 8, 3);
        grid.add(five, 9, 3);
        grid.add(six, 10, 3);
        grid.add(seven, 8, 4);
        grid.add(eight, 9, 4);
        grid.add(nine, 10, 4);
        grid.add(zero, 8, 5, 3, 1);
        grid.add(volDown, 8, 6);
        grid.add(volUp, 9, 6);
        grid.add(curVoLabel, 10, 6);
        grid.add(new Label(), 8, 7, 3, 1);

        // Main
        main.getChildren().addAll(grid);

        Scene scene = new Scene(main);
        stage.setScene(scene);
        stage.setTitle("Monday Morning Cartoons");
        stage.show();

        currentChannel.play();
    }

    /**
     * Helper function: makes lables with certain formating.
     */
    public Label makeLabel(String text, Color textColor, Color backgroundColor){
        Label label = new Label(text);
        label.setTextFill(textColor);
        label.setBackground(new Background(new BackgroundFill(backgroundColor, new CornerRadii(0), Insets.EMPTY)));
        label.setFont(new Font("Courier New", 24));
        label.setMinSize(REMOTE_BUTTON_SIZE, REMOTE_BUTTON_SIZE*(1.1));
        label.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        return label;
    }

    /**
     * Helper function: makes buttons with certain formating.
     */
    public Button makeButton(String text, String args){
        Button button = new Button(text);
        button.setStyle(args);
        button.setMinSize(REMOTE_BUTTON_SIZE, REMOTE_BUTTON_SIZE*(1.1));
        button.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        return button;
    }

    /**
     * Helper function: makes buttons with images and certain formating.
     */
    public Button makeImageButton(String args, FileInputStream file){
        ImageView screen = new ImageView(new Image(file));
        
        Button button = new Button("", screen);
        button.setStyle(args);
        button.setMinSize(REMOTE_BUTTON_SIZE, REMOTE_BUTTON_SIZE*(1.1));
        button.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        return button;
    }
  
    /**
     * Helper function: changes channels when a button is pressed and called all necessary functions.
     */
    public void changeChannel(int channelNumber) {
        Channel newChannel = CHANNELS[channelNumber];
        if(newChannel != this.currentChannel) {
            this.currentChannel.stop();
            this.description.setText(" " + channelNumber + " - " + newChannel.getDescription());
            double volume = this.currentChannel.getVolume();
            newChannel.setVolume(volume);
            newChannel.play();
            this.screen.setImage(new Image(newChannel.getImage())); // screen is an ImageView
            this.currentChannel = newChannel;
        }
    }

    /**
     * Helper function: lowers volume when loweVol button is pressed.
     */
    public void decreaseVol(){
        currentChannel.decreaseVolume();
        curVolVal = currentChannel.getVolume();
        curVoLabel.setText(String.valueOf((int)(curVolVal*10)));
    }

    /**
     * Helper function: increases volume when increVol button is pressed.
     */
    public void increaseVol(){
        currentChannel.increaseVolume();
        curVolVal = currentChannel.getVolume();
        curVoLabel.setText(String.valueOf((int)(curVolVal*10)));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
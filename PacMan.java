import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PacMan extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        VBox main = new VBox();

        main.getChildren().addAll(
            makeButton("Chomp!", "./media/sounds/chomp.wav"),
            makeButton("Eat!", "./media/sounds/eat.wav"),
            makeButton("End!", "./media/sounds/end.wav"),
            makeButton("Start!", "./media/sounds/start.wav")
        );
        
        Scene scene = new Scene(main);
        stage.setScene(scene);
        stage.show();
    }

    private static Button makeButton(String text, String path){
        Button button = new Button(text);
        button.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        SoundPlayer player = new SoundPlayer(path);
        button.setOnAction(player);
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

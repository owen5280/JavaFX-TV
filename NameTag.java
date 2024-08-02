import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NameTag extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        VBox main = new VBox();

        VBox labels = new VBox();

        Label name = makeLabel("NAME", new Font("Comic Sans MS", 64));

        labels.getChildren().addAll(
            makeLabel("HELLO MY NAME IS ", new Font("Arial", 36)),
            name  
        );

        labels.setBorder(new Border(new BorderStroke(
            Color.BLUE, 
            BorderStrokeStyle.SOLID, 
            new CornerRadii(30),
            BorderStroke.THICK)));
        labels.setPadding(new Insets(20));

        TextField field = new TextField();
        field.setPromptText("Enter Your Name");
        field.setAlignment(Pos.CENTER);

        Button update = new Button("Update Name Tag");
        update.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

        // PrintOnPress pop = new PrintOnPress();
        // update.setOnAction(pop);
        Updater updater = new Updater(field, name);
        update.setOnAction(updater);

        Button clear = new Button("Clear");
        clear.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Clearer c = new Clearer(name);
        clear.setOnAction(c);

        main.getChildren().addAll(labels, field, update, clear);

        Scene scene = new Scene(main);
        stage.setScene(scene);
        stage.setTitle("Name Tag");
        stage.show();
    }

    private static Label makeLabel(String text, Font font){
        Label label = new Label(text);
        label.setFont(font);
        label.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        label.setAlignment(Pos.CENTER);
        return label;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

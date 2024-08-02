import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import media.images.ImageSwitcher;

public class ImageViewer extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
      
        Image image = new Image("file:./media/images/smb.gif");
        ImageView view = new ImageView(image);
        VBox box = new VBox();
        box.getChildren().add(view);

        Button bwitch = new Button("Switch!");

        Image alt = new Image("file:./media/images/sunflowers.jpg");
        ImageSwitcher switcher = new ImageSwitcher(alt, view);
        bwitch.setOnAction(switcher);
        box.getChildren().add(bwitch);
        
        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.setTitle("Image Viewer");     
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
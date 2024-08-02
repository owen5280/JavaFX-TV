package media.images;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageSwitcher implements EventHandler<ActionEvent>{
    private Image image;
    private ImageView view;

    public ImageSwitcher(Image image, ImageView view){
        this.image = image;
        this.view = view;
    }
    
    @Override
    public void handle(ActionEvent event) {
        Image old = view.getImage();
        view.setImage(image);
        image = old;        
    }
}

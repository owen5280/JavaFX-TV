import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class Clearer implements EventHandler<ActionEvent>{

    private Label label;

    public Clearer(Label label){
        this.label = label;
    }

    @Override
    public void handle(ActionEvent event) {
        label.setText("");        
    }
    
}

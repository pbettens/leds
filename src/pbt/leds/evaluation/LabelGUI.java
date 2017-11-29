package pbt.leds.evaluation;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Une classe label. 
 * 
 * Remarque. Ç'eût été mieux d'en faire un dialog.
 * @author Pierre Bettens (pbt) <pbettens@heb.be>
 */
public class LabelGUI extends Application implements ChangeListener<Number>{

    private Label label;
    
    @Override
    public void start(Stage stage) throws Exception {
        label = new Label("1");
        label.setFont(new Font(100));
        
        BorderPane root = new BorderPane();
        root.setCenter(label);
        
        Scene scene = new Scene(root, 120, 120);
        
        stage.setTitle("Plop label");
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void changed(ObservableValue<? extends Number> ov, 
            Number oldValue, Number newValue) {
        label.setText("" + newValue);        
    }
    
}

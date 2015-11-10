package pbt.leds.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@heb.be>
 */
public class TestGLed extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //GLed led = new GLed();
        //GLed led = new GLedClickable();
        //GLed led = new GLedClickableNoimplement();
        GLedBinding led = new GLedBinding();
        
        Button button = new Button("Change");
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                led.setOn(!led.isOn());
                event.consume();
            }
        });
        ColorPicker colorPicker = new ColorPicker(Color.RED);
        colorPicker.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                led.setColor(colorPicker.getValue());
                event.consume();
            }
        });
        
        BorderPane root = new BorderPane();
        root.setCenter(led);
        HBox box = new HBox();
        box.getChildren().add(button);
        box.setSpacing(5);
        box.getChildren().add(colorPicker);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(5, 0, 5, 0));
        root.setBottom(box);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello L E D");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

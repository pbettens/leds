package pbt.leds.evaluation;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import pbt.leds.javafx.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Évaluation alg3ir 2017. 
 * Une solution de l'évaluation réalisée dans le temps imparti avec des 
 * imperfections. 
 * 
 * @author Pierre Bettens (pbt) <pbettens@heb.be>
 */
public class MainGUI extends Application {
    
    private final static Random R = new Random();
    
    @Override
    public void start(Stage primaryStage) {
        GLedsBox leds = new GLedsBox();
        
        Label label = new Label("1");
        label.setFont(new Font(100));
        
        Button button = new Button("Add");
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                GLed led = new GLed();
                led.setColor(new Color(R.nextDouble(), R.nextDouble(), 
                        R.nextDouble(), R.nextDouble()));
                leds.addLed(led);                   
                event.consume();
            }
        });
        
        Button buttonOpen = new Button("Open");
        buttonOpen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    LabelGUI lg = new LabelGUI();
                    leds.numberProperty().addListener(lg);
                    lg.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(MainGUI.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        });
        
        leds.numberProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, 
                    Number oldValue, Number newValue) {
                label.setText("" + newValue);
            }
        });                
        
        BorderPane root = new BorderPane();        
        root.setCenter(leds);        
        HBox box = new HBox();
        box.getChildren().add(label);
        box.setSpacing(45);
        box.getChildren().add(button);        
        box.getChildren().add(buttonOpen);        
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(5, 0, 5, 0));
        root.setBottom(box);
        
        Scene scene = new Scene(root, 1000, 250);
        
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

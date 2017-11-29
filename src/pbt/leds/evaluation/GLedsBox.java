package pbt.leds.evaluation;

import pbt.leds.javafx.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

/**
 * Boite de leds avec une propriété nombre de leds. 
 * 
 * @author Pierre Bettens (pbt) <pbettens@heb.be>
 */
public class GLedsBox extends Parent {

    protected IntegerProperty number = new SimpleIntegerProperty(0);
    protected HBox box = new HBox();
    
    public GLedsBox() {        
        box.setSpacing(20);
        box.setPadding(new Insets(17));
        ScrollPane sp = new ScrollPane();        
        sp.setContent(box);
        sp.setHmax(1000);
        sp.setPrefSize(1000, 150);
        getChildren().add(sp);        
        addLed(new GLed());           
    }
    
    public final void addLed(GLed led){
        box.getChildren().add(led);
        setNumber(getNumber()+1);
    }
    
    public final IntegerProperty numberProperty(){
        return number;
    }
    
    public final Integer getNumber(){
        return number.getValue();
    }
    
    public final void setNumber(Integer n){
        number.setValue(n);
    }

   
}

package pbt.leds.javafx;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Parent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Les avec deux propriétés.
 * L'une est boolean tandis que l'autre est de type Color.
 * 
 * @author Pierre Bettens (pbt) <pbettens@heb.be>
 */
public class GLed extends Parent {
    
    
    protected BooleanProperty on = new SimpleBooleanProperty(true);
    protected ObjectProperty<Color> color = 
            new ObjectPropertyBase<Color>(Color.RED) {

        @Override
        public Object getBean() {
            System.out.println("@todo");
            return color;
        }

        @Override
        public String getName() {
            return "Color";
        }
    };

    private Circle circle;
    
    public GLed() {
        circle = new Circle(50);
        circle.setFill(color.get());  
        circle.setStroke(Color.BLACK);
        getChildren().add(circle);
    }
    
    public final void setOn(boolean aon){
        on.set(aon);
        if (aon) {
            circle.setFill(color.get());
        } else {
            circle.setFill(Color.WHITE);
        }
    }
    
    public final boolean isOn(){
        return on.get();
    }
    
    public final BooleanProperty onProperty(){
        return on;
    }
    
    public final Color getColor() {
        return color.get();
    }
    
    public final void setColor(Color c){
        color.set(c);
        circle.setFill(c);
    }
    
    public final ObjectProperty<Color> colorProperty(){
        return color;
    }
    
    
    
}

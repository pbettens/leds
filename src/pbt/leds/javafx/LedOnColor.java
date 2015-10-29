package pbt.leds.javafx;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * Led avec deux propriétés.
 * L'une est boolean tandis que l'autre est de type Color.
 * 
 * @author Pierre Bettens (pbt) <pbettens@heb.be>
 */
public class LedOnColor {
    
    /**
     * Propriété on / off d'une led. Allumé ou éteint.
     */
    protected BooleanProperty on = new SimpleBooleanProperty(true);
    
    /**
     * Propriété color d'une led. 
     * Sa couleur lorsqu'elle est allumée.
     */
    protected ObjectProperty<Color> color = 
            new ObjectPropertyBase<Color>(Color.RED) {

        @Override
        public Object getBean() {            
            return color;
        }

        @Override
        public String getName() {
            return "Color property";
        }
    };

 
    /**
     * Setter on
     * @param aon allumé ou éteint 
     */
    public final void setOn(boolean aon){
        on.set(aon);
    }
    
    /**
     * Getter on.
     * @return true si la led est allumée
     */
    public final boolean isOn(){
        return on.get();
    }
    
    /**
     * Propriété on 
     * @return la propriété on  
     */
    public final BooleanProperty onProperty(){
        return on;
    }
    
    /**
     * Getter color
     * @return 
     */
    public final Color getColor() {
        return color.get();
    }
    
    /**
     * Setter color.
     * @param c 
     */
    public final void setColor(Color c){
        color.set(c);
    }
    
    /**
     * Propritété color.
     * @return la propriété color
     */
    public final ObjectProperty<Color> colorProperty(){
        return color;
    }
    
}

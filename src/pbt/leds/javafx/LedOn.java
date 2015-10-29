package pbt.leds.javafx;

import java.io.Serializable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * Led avec une unique propriété on.
 * Illustration d'un javabean non graphique. 
 * 
 * @author Pierre Bettens (pbt) <pbettens@heb.be>
 */
public class LedOn implements Serializable {

    /**
     * Propriété on / off d'un led. Allumé ou éteint.
     */
    protected BooleanProperty on = new SimpleBooleanProperty(true);

    /**
     * Setter de la propriété on
     * @param aon 
     */
    public final void setOn(boolean aon){
        on.set(aon);
    }
    
    /**
     * Getter on 
     * @return true si la led est allumée
     */
    public final boolean isOn(){
        return on.get();
    }
    
    /**
     * La propriété on. 
     * @return la propriété on 
     */
    public final BooleanProperty onProperty(){
        return on;
    }
    
}

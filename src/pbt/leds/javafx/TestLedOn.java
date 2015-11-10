package pbt.leds.javafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Illustration de l'ajout d'un écouteur. 
 * 
 * @author Pierre Bettens (pbt) <pbettens@heb.be>
 */
public class TestLedOn {
    
    public static void main(String[] args) {
        // Ajout d'un écouteur
        LedOn led = new LedOn();
        led.onProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, 
                    Boolean oldValue, Boolean newValue) {
                // I've changed. Promise
                System.out.println("Led change de " 
                    + oldValue + " vers " + newValue);

                
            }
        });
        
        led.setOn(true);
        led.setOn(false);
        led.setOn(true);
    }
    
}

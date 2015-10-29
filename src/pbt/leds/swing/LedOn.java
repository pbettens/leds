package pbt.leds.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import javax.swing.JPanel;

/** 
 * Un JLed est un composant (<i>java bean</i>) representant une led
 * électronique.
 *
 * Une led a la capacité d'être allumée ou éteinte et peut changer de couleur. 
 *
 * Created on 18 octobre 2007, 11:44
 * Revised on 11 octobre 2011
 * One more october 2015
 * @author Pierre Bettens (pbt) <pbettens@heb.be>
 */
public class LedOn extends JPanel
		implements Serializable {
    
    public static final String PROPERTY_ON = "pbt.leds.Led, propoerty on";
    public static final String PROPERTY_COLOR = "pbt.leds.Led, propoerty color";
    
    private final int L_WIDTH = 80;
    private final int L_HEIGHT = 80;
    private final int PADDING = 15;
    
    private Color color ; 
    private boolean on ;
    
    /** Creates a new instance of JLed */
    public LedOn() {
        super();        
        this.setPreferredSize(new Dimension(L_WIDTH,L_HEIGHT));
        this.color = Color.BLACK;
        this.on = false;
    }

    /** @return color */
    public Color getColor() {
        return color;
    }

    /** @param color for JLed */
    public void setColor(Color color) {
        if (color.equals(Color.WHITE)) {
            throw new IllegalArgumentException(
                    "Invalid color (you try off color)");
        }
        Color oldValue = this.color;
        this.color = color;
        if (!oldValue.equals(color)) {
            firePropertyChange(PROPERTY_COLOR, oldValue, color);
        }
    }

    
    public boolean isOn() {
        return on;
    }

    public void setOn(boolean newValue) {
        // Be careful this 2 statements are ordonned not for the 
        // bean but for this.on and on.         
        boolean oldValue = this.on ; 
        this.on = newValue ;
        if ( oldValue != newValue) {
            this.firePropertyChange(PROPERTY_ON,oldValue,newValue);
        }
        repaint();
    }
   
    
    
}

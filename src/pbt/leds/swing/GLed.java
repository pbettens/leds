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
 * Un GLed est un composant graphique (<i>java bean</i>) representant une led
 * électronique.
 *
 * Une led a la capacité d'être allumée ou éteinte et peut changer de couleur. 
 *
 * @author Pierre Bettens
 */
public class GLed extends JPanel
		implements Serializable {
    
    public static final String PROPERTY_ON = "pbt.leds.Led, propoerty on";
    public static final String PROPERTY_COLOR = "pbt.leds.Led, propoerty color";
    
    private final int L_WIDTH = 80;
    private final int L_HEIGHT = 80;
    private final int PADDING = 15;
    
    private Color color ; 
    private boolean on ;
    
    /** Creates a new instance of JLed */
    public GLed() {
        super();        
        this.setPreferredSize(new Dimension(L_WIDTH,L_HEIGHT));
        this.color = Color.BLACK;
        this.on = false;
    }

    /** @return color */
    public Color getColor() {
        return color;
    }

    /** @param color for GLed */
    public void setColor(Color color) {
        if (color.equals(Color.WHITE)) {
            throw new IllegalArgumentException(
                    "Invalid color (you try off color)");
        }
        Color oldValue = this.color;
        this.color = color;
        // Inutile de vérifier que les valeurs sont différentes, le file
        // s'en charge
        firePropertyChange(PROPERTY_COLOR, oldValue, color);
        repaint();
    }

    
    /**
     * Getter
     * @return true si la led est allumée 
     */
    public boolean isOn() {
        return on;
    }

    /**
     * Setter
     * @param newValue 
     */
    public void setOn(boolean newValue) {
        // Be careful this 2 statements are ordonned not for the 
        // bean but for this.on and on.         
        boolean oldValue = this.on ; 
        this.on = newValue ;
        firePropertyChange(PROPERTY_ON,oldValue,newValue);
        repaint();
    }
   
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(
               RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(
               RenderingHints.KEY_ALPHA_INTERPOLATION,
               RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(
               RenderingHints.KEY_ANTIALIASING,
               RenderingHints.VALUE_ANTIALIAS_ON);        
        g2.setColor(Color.BLACK) ;
        g2.drawOval(L_WIDTH/2-PADDING,
                L_HEIGHT/2-PADDING,
                L_WIDTH-2*PADDING,
                L_HEIGHT-2*PADDING) ;
        if ( isOn() ) {
            g2.setColor(color) ;
        } else {
            g2.setColor(Color.WHITE) ;
        }
        g2.fillOval(L_WIDTH/2-PADDING,
                L_HEIGHT/2-PADDING,
                L_WIDTH-2*PADDING,
                L_HEIGHT-2*PADDING) ;
    }
     
}

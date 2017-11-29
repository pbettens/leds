package pbt.leds.swing;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.Timer;
import sun.security.ssl.Debug;

/**
 * Représente le compteur binaire. 
 * @author pit
 */
public class JLedsCounter extends JPanel implements Serializable {
    // Nombre de leds

    private static final int N = 8;
    private GLed[] jleds;
    private boolean start;
    private Timer timer;

    public JLedsCounter() {
        super();
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        // Model
        jleds = new GLed[N];
        jleds[0] = new GLed();
        jleds[0].setOn(false);
        add(jleds[0]);

        for (int i = 1; i < N; i++) {
            final GLed led = jleds[i] = new GLed();
            led.setOn(false);
            // Je dois modifier l'action de mon led par rapport à celle définie
            // dans le composant
            jleds[i-1].addPropertyChangeListener(new PropertyChangeListener() {

                public void propertyChange(PropertyChangeEvent evt) {
                    if (evt.getPropertyName().equals(GLed.PROPERTY_ON)
                            && !(Boolean) evt.getNewValue()) {                        
                        led.setOn(!led.isOn());
                    }
                }
            });
            add(led);
        }
        start = false;
        timer = new Timer(500, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                jleds[0].setOn(!jleds[0].isOn());
            }
        });
    }

    public void setStart(boolean start) {
        this.start = start;
        if (start) {
            timer.start();
        } else {
            timer.stop();
        }
    }

    public void reset() {
        for (GLed jLed : jleds) {
            jLed.setOn(false);
        }
        //timer.restart();
    }
}

package pbt.leds.swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@heb.be>
 */
public class GLedClickableNoimplement extends GLed {

    public GLedClickableNoimplement() {
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                setOn(!isOn());
            }
        
            
            
        });
    }
}

package pbt.leds.swing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@heb.be>
 */
public class GLedClickable extends GLed implements MouseListener {

    public GLedClickable() {
        addMouseListener(this);
    }

   @Override
    public void mouseClicked(MouseEvent e) {
        setOn(!isOn());
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

}

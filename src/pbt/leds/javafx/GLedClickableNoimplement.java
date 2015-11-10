package pbt.leds.javafx;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Led avec deux propriétés.
 * L'une est boolean tandis que l'autre est de type Color. L'écouteur est une
 * classe anonyme. 
 * 
 * La version sans lambda associée est en commentaire. 
 * 
 * @author Pierre Bettens (pbt) <pbettens@heb.be>
 */
public class GLedClickableNoimplement extends GLed {

    public GLedClickableNoimplement() {
        super();
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            setOn(!isOn());
        });
    }
    
    /* 
    public GLedClickableNoimplement() {
        super();
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setOn(!isOn());
            }
        });
    }
    */
    
}

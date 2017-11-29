package pbt.leds.swing;

import java.awt.datatransfer.Transferable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.TransferHandler;

/**
 *
 * @author pit
 */
public class LedTransferHandler extends TransferHandler {

    @Override
    protected Transferable createTransferable(JComponent sourceOfDrag) {
         return (JLedTransferable) sourceOfDrag;
    }

    /**
     * Définit le type de drag : COPY, NONE, MOVE, COPY_OR_MOVE.
     * NONE rend le drag impossible
     */
    @Override
    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }

    @Override
    public Icon getVisualRepresentation(Transferable t) {
        System.err.println("Not called");
        return super.getVisualRepresentation(t);        
    }
}

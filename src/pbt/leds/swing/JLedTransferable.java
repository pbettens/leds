package pbt.leds.swing;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.TransferHandler;

/**
 *
 * @author pit
 */
public class JLedTransferable extends GLed implements Transferable{

    /*
     * 0 - GLed flavor
     * 1 - String flavor
     */
    private DataFlavor df[];

    public JLedTransferable() throws ClassNotFoundException {
        super();
        df = new DataFlavor[2];
        df[0] = new DataFlavor(
                DataFlavor.javaJVMLocalObjectMimeType
                + ";class="
                +JLedTransferable.class.getName());
        df[1] = DataFlavor.stringFlavor;

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                 JComponent c = (JComponent) me.getSource();
                 TransferHandler handler = c.getTransferHandler();
                 handler.exportAsDrag(c, me, TransferHandler.MOVE);
                 me.consume();
            }
        });
        setTransferHandler(new LedTransferHandler(){});
    }




    public Object getTransferData(DataFlavor flavor)
            throws UnsupportedFlavorException, IOException {
        if (df[0].equals(flavor)) {
            return this;
        } else if (df[1].equals(flavor)) {
            return "JLed "+ getColor() +", "
                    + (isOn() ? "on":"off");
        } else throw new UnsupportedFlavorException(flavor);
    }

    public DataFlavor[] getTransferDataFlavors() {
        return df;
    }

    public boolean isDataFlavorSupported(DataFlavor flavor) {
        boolean isSupported = false;
        for (DataFlavor dataFlavor : df) {
            isSupported |= dataFlavor.equals(flavor);
        }
        return isSupported;
    }


}

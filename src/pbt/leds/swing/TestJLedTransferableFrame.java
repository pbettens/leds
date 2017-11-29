package pbt.leds.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.ScrollPane;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.TransferHandler;

/**
 * Frame permettant de tester le drag and drop de led.
 *
 * Ce gui de tests n'affiche que les 5 premiers leds (pas de scrollbar). 
 * 
 * @author pit
 */
public class TestJLedTransferableFrame extends JFrame {

    private JPanel pFrom, pTo;
    private JScrollPane scrollFrom, scrollTo;
    private JButton bAdd;
    // Pour générer des leds de couleur aléatoire
    private static Random r = new Random();

    public TestJLedTransferableFrame() throws HeadlessException {
        super("Leds transferables");
        pFrom = new JPanel();
        pFrom.setBorder(BorderFactory.createTitledBorder("from"));
        // pFrom  est capable de réceptionner un drop
        pFrom.setTransferHandler(new JPanel4JLedTransferHandler(pFrom));

        pTo = new JPanel();
        pTo.setBorder(BorderFactory.createTitledBorder("to"));
        // pTo  est capable de réceptionner un drop
        pTo.setTransferHandler(new JPanel4JLedTransferHandler((pTo)));
        
        bAdd = new JButton("Add JLed");
        bAdd.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                bAddAction();
            }
        });

        scrollFrom = new JScrollPane(pFrom);
        scrollFrom.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollFrom.setPreferredSize(new Dimension(650, 150));
        add(scrollFrom, BorderLayout.NORTH);
        add(bAdd, BorderLayout.CENTER);
        scrollTo = new JScrollPane(pTo);
        scrollTo.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollTo.setPreferredSize(new Dimension(650, 150));
        add(scrollTo, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void bAddAction() {
        try {
            JLedTransferable led = new JLedTransferable();
            led.setColor(getRandomColor());
            led.setOn(true);
            pFrom.add(led);
            validate();
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this,
                    "Erreur lors de l'instanciation d'un JLedTransferable",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private Color getRandomColor() {
        return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    private class JPanel4JLedTransferHandler extends TransferHandler {

        private DataFlavor maDf;
        private JPanel destination;

        public JPanel4JLedTransferHandler(JPanel destination) {
            this.destination = destination;
        }


        @Override
        public boolean canImport(JComponent source, DataFlavor[] dfs) {
            try {
                if (maDf == null) {
                    maDf = new DataFlavor(
                            DataFlavor.javaJVMLocalObjectMimeType
                            + ";class="
                            + JLedTransferable.class.getName());
                }
            } catch (ClassNotFoundException ex) {
                System.err.println("DataFlavor inconstructible: "
                        + ex.getMessage());
                return false;
            }
            for (DataFlavor df : dfs) {
                if (df.equals(maDf)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport info) {
            if (!info.isDrop()) {
                return false;
            }
            Transferable t = info.getTransferable();
            JLedTransferable e;
            try {
                e = (JLedTransferable) t.getTransferData(maDf);
            } catch (UnsupportedFlavorException ex) {
                return false;
            } catch (IOException ex) {
                return false;
            }
            //pTo.add(e);
            destination.add(e);
            pTo.updateUI();
            pFrom.updateUI();
            validate();
            return true;
        }
    }
}

/*
 * TwoJLedsFrameListenerTest.java
 * Created on 18 octobre 2007, 15:37
 * @author pit
 */

package pbt.leds.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Frame permettant de tester deux leds dans un contexte écouteur/écouté.
 * 
 * Une led change en fonction de l'action sur le bouton, l'autre est à l'écoute
 * de la première. 
 *
 * Created on 18 octobre 2007, 15:37
 * @author pit

 */
public class TestTwoJLedsFrameListener extends JFrame implements PropertyChangeListener {
    //private JFrame this ; 
    private GLed lRed ;
    private GLed lGreen ;
    private JButton btnSwitch ; 
    
    /** Creates a new instance of TwoJLedsFrameListenerTest */
    public TestTwoJLedsFrameListener() {
        super("L E D S") ;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout()); 
        lRed = new GLed() ;
        lRed.setColor(Color.RED) ;
        lRed.setOn(false);
        lRed.repaint();
        this.add(lRed, BorderLayout.WEST) ;
        lGreen = new GLed() ;
        lGreen.setColor(Color.GREEN) ;
        lGreen.setOn(true);
        //lGreen.repaint();
        this.add(lGreen, BorderLayout.CENTER) ;
        
        btnSwitch = new JButton("Switch") ; 
        btnSwitch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
 //               lRed.change();
            }
        }) ; 
        this.add(btnSwitch, BorderLayout.EAST);

//        lRed.addPropertyChangeListener(lGreen);    
        lRed.addPropertyChangeListener(this);
        this.pack() ; 
        this.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(GLed.PROPERTY_ON)) {
            System.out.println("Led rouge m'informe");
        }
        
    }


}

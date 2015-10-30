package pbt.leds.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeListener;

/**
 * JLedFrameTest, frame de test du bean GLed.
 *
 *
 * Contient un led et un bouton on/off.
 *
 * Created on 18 octobre 2007, 18:41
 * @author pit

 */
public class TestGLed {
    private JFrame jf ; 
    private JButton btnOnOff ; 
    private GLed led ;
    
    /**
     * Creates a new instance of JLedFrameTest
     */
    public TestGLed() {
        jf = new JFrame("Test LED"); 
        btnOnOff = new JButton("On/Off"); 
        btnOnOff.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                led.setOn(!led.isOn());
            }
        });
        
        //led = new GLed() ;
        led = new GLedClickable();        
        led.setColor(Color.RED);

        jf.setPreferredSize(new Dimension(200, 200));        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(led, BorderLayout.CENTER);
        jf.add(btnOnOff, BorderLayout.SOUTH);
        jf.pack() ; 
        jf.setVisible(true);
    }
    
    public static void main(String[] args) {
        new TestGLed();
    }
    
}

/*
 * Main.java
 *
 * Created on 18 octobre 2007, 11:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package pbt.leds.swing;

/**
 *
 * @author pit
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //new TwoJLedsFrameListenerTest();
        new TestGLed();
        new TestJLedTransferableFrame();        
        new GUICounter().setVisible(true);
    }
}

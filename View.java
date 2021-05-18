
import java.awt.event.*;

/**
 * Write a description of class View here.
 *
 * @author Niklas Rösner, Laurens Birkenbach, Julius Rommel (30.04.2021)
 * @version 0.1
 */

// wird später rüberkopiert
public class View 
{

    private boolean fwd;
    private boolean back;
    private boolean left;
    private boolean right;

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

        
        if(e.getKeyCode() == KeyEvent.VK_W){ 
            //vorwärts
            //spielr.geradegehen();
            fwd = true;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_S){ 
            //rückwärts
            //spielr.rueckwertsgehen();
            back = true;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_A){ 
            //links
            //spielr.linksgehen();
            left = true;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_D){ 
            //rechts
            //spielr.rechtsgehen()
            right = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        //vorwärts
        if(e.getKeyCode() == KeyEvent.VK_W){ 
            fwd = false;
        }
        //rückwärts
        if(e.getKeyCode() == KeyEvent.VK_S){ 
            back = false;
        }
        //links
        if(e.getKeyCode() == KeyEvent.VK_A){ 
            left = false;
        }
        //rechts
        if(e.getKeyCode() == KeyEvent.VK_D){ 
            right = false;
        }
    }

}

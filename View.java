
import java.awt.event.*;

/**
 * Write a description of class View here.
 *
 * @author Niklas Rösner, Laurens Birkenbach (07.05.2021)
 * @version 0.2
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

        //vorwärts
        if(e.getKeyCode() == KeyEvent.VK_W){ 
            fwd = true;
        }
        //rückwärts
        if(e.getKeyCode() == KeyEvent.VK_S){ 
            back = true;
        }
        //links
        if(e.getKeyCode() == KeyEvent.VK_A){ 
            left = true;
        }
        //rechts
        if(e.getKeyCode() == KeyEvent.VK_D){ 
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

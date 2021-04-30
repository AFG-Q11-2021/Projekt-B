import.java.awt.event.*;
/**
 * Write a description of class View here.
 *
 * @author Niklas Rösner, Laurens Birkenbach (30.04.2021)
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
            fwd = true;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_S){ 
            fwd = true;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_A){ 
            fwd = true;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_D){ 
            fwd = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){ 
            fwd = false;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_S){ 
            fwd = false;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_A){ 
            fwd = false;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_D){ 
            fwd = false;
        }
    }

}

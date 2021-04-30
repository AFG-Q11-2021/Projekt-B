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

        //vorwärts
        if(e.getKeyCode() == KeyEvent.VK_W){ 
            fwd = true;
        }
        //rückwärts
        if(e.getKeyCode() == KeyEvent.VK_S){ 
            fwd = true;
        }
        //links
        if(e.getKeyCode() == KeyEvent.VK_A){ 
            fwd = true;
        }
        //rechts
        if(e.getKeyCode() == KeyEvent.VK_D){ 
            fwd = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        //vorwärts
        if(e.getKeyCode() == KeyEvent.VK_W){ 
            fwd = false;
        }
        //rückwärts
        if(e.getKeyCode() == KeyEvent.VK_S){ 
            fwd = false;
        }
        //links
        if(e.getKeyCode() == KeyEvent.VK_A){ 
            fwd = false;
        }
        //rechts
        if(e.getKeyCode() == KeyEvent.VK_D){ 
            fwd = false;
        }
    }

}

<<<<<<< HEAD
<<<<<<< HEAD

mport.java.awt.event.*;
=======
import.java.awt.event.*;
>>>>>>> a0bcf831b97d90f83ae8ce214e7affb08ffe235d
=======
import.java.awt.event.*;
>>>>>>> a0bcf831b97d90f83ae8ce214e7affb08ffe235d
/**
 * Write a description of class View here.
 *
 * @author Niklas Rösner, Laurens Birkenbach (30.04.2021)
 * @version 0.1
 */

// wird später rüberkopiert
public class View 
{
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    
=======
=======
>>>>>>> a0bcf831b97d90f83ae8ce214e7affb08ffe235d
=======
>>>>>>> a0bcf831b97d90f83ae8ce214e7affb08ffe235d
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

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> c2c4e1ccabb71efc0a226be7310b13bae1b81e9a
=======
>>>>>>> a0bcf831b97d90f83ae8ce214e7affb08ffe235d
=======
>>>>>>> a0bcf831b97d90f83ae8ce214e7affb08ffe235d
}

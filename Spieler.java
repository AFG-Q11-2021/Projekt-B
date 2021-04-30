// Autoren: Martin ; Lasse//
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.awt.Graphics;
import java.awt.Color;
>>>>>>> a0bcf831b97d90f83ae8ce214e7affb08ffe235d
=======
import java.awt.Graphics;
import java.awt.Color;
>>>>>>> a0bcf831b97d90f83ae8ce214e7affb08ffe235d
public class Spieler
{
    private int px; // Postion x (Koordinatensystem)//
    private int py; // Postion y (Koordinatensystem)//
    private String username;
    
    public Spieler(String usernameNeu, Graphics stift)
    {
        username= usernameNeu;
<<<<<<< HEAD
<<<<<<< HEAD
        int px = 1;
        int py = 1;
=======
        int px = 1;//Startpunkt des Spielers//
        int py = 1;



        
>>>>>>> a0bcf831b97d90f83ae8ce214e7affb08ffe235d
=======
        int px = 1;//Startpunkt des Spielers//
        int py = 1;

        stift.setColor(farbe);
        stift.fillRect(px, py, 20, 20);
        stift.setColor(Color.BLACK);
        stift.drawRect(px,py, 20, 20);

        
>>>>>>> a0bcf831b97d90f83ae8ce214e7affb08ffe235d
    }
    public void paint (Graphics stift)
    {
        
    }
    public void geradeausGehen()
    {
        py--;
    }
    public void rueckwertsGehen()
    {
        py++;
    }
    public void linksGehen()
    {
        px--;
    }
    public void rechtsGehen()
    {
        px++;
    }
<<<<<<< HEAD
<<<<<<< HEAD
    public Cell getPosition()
=======
    public Karte getPosition()
>>>>>>> a0bcf831b97d90f83ae8ce214e7affb08ffe235d
=======
    public Karte getPosition()
>>>>>>> a0bcf831b97d90f83ae8ce214e7affb08ffe235d
    {//Aktualisiert die Position des Spielers//
        
    }
    
}

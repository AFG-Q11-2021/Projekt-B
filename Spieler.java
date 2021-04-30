// Autoren: Martin ; Lasse//

import java.awt.Graphics;
import java.awt.Color;

public class Spieler
{
    private int x; // Postion x (Koordinatensystem)//
    private int y; // Postion y (Koordinatensystem)//
    private String username;
    private int leben;
    public Spieler(String usernameNeu, Graphics stift)
    {
        username= usernameNeu;
<<<<<<< HEAD
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
        
=======
        int x = 1;//Startpunkt des Spielers//
        int y = 1;
        int leben = 5;
>>>>>>> 20ae19b908190b92fb1fffc5261aefc02e1ec02a
    }
    
    public void geradeausGehen()
    {
        y--;
    }

    public void rueckwertsGehen()
    {
        y++;
    }

    public void linksGehen()
    {
        x--;
    }

    public void rechtsGehen()
    {
        x++;
    }

    public Karte getPosition()
    {//Aktualisiert die Position des Spielers//
    }
}

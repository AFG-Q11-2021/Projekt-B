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
        int px = 1;//Startpunkt des Spielers//

        int py = 1;//Startpunkt des Spielers//

        stift.setColor(farbe);
        stift.fillRect(px, py, 20, 20);
        stift.setColor(Color.BLACK);
        stift.drawRect(px,py, 20, 20);

        

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

    
    public Karte getPosition()
    {//Aktualisiert die Position des Spielers//
        int x = 1;//Startpunkt des Spielers//
        int y = 1;
        int leben;
    }
    
    public void geradeausGehen()
    {
       if(y>0)
       {
          y--;
       }
    }
    public void rueckwertsGehen()
    {
        if(y<Karte.getSizeX()) //Karte ist eine Klasse, muss noch in ein Objekt umgewandelt werden//
        {
           y++;
        }
    }

    public void linksGehen()
    {
        if(x>0)
        {
           x--;
        }
    }

    public void rechtsGehen()
    {
        x++;
    }

    public Karte getPosition()
    {//Aktualisiert die Position des Spielers//
    }
}

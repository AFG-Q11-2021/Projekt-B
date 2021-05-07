// Autoren: Martin ; Lasse//

import java.awt.Graphics;
import java.awt.Color;

public class Spieler
{
    private double x; // Postion x (Koordinatensystem)//
    private double y; // Postion y (Koordinatensystem)//
    private String username;
    private int leben;
    private double rotation;
    
    public Spieler(String usernameNeu, Graphics stift)
    {
        username= usernameNeu;
        int px = 1;//Startpunkt des Spielers//
        int py = 1;//Startpunkt des Spielers//
        int leben = 5;
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
        if(y<Karte.getSizeX()) //Karte ist eine Klasse, muss noch in ein Objekt umgewandelt werden//
        {
            x++;
        }
    }


    public Karte getPosition()

    {//Aktualisiert die Position des Spielers//


    }
    
    public void geradeausGehen()
    {
        if(y>0)
        {
          x=x+(1*Math.cos(rotation));
        }
    }
    
    public void rueckwertsGehen()
    {
        if(y<Karte.getSizeX()) //Karte ist eine Klasse, muss noch in ein Objekt umgewandelt werden//
        {
           y++;
        }
    }
    
    public void rotation()
    {
        
    }
    }
 

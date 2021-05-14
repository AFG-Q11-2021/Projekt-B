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
    private Karte karte;
    
    public Spieler(String usernameNeu)
    {
        username= usernameNeu;
        int x = 1;//Startpunkt des Spielers//
        int y = 1;//Startpunkt des Spielers//
        int leben = 5;
        double rotation=90.0;
    }

    public void linksGehen()
    {
        if(x>0)
        {
            x=x+(1*Math.cos(rotation-90));
            y=y+(1*Math.sin(rotation-90));
        }
    }

    public void rechtsGehen()
    {
        if(y<karte.getSizeX()) //Karte ist eine Klasse, muss noch in ein Objekt umgewandelt werden//
        {
            x=x+(1*Math.cos(rotation+90));
            y=y+(1*Math.sin(rotation+90));
        }
    }

    public Karte getPosition()

    {//Aktualisiert die Position des Spielers//

        return new Karte();
    }
    
    public void geradeausGehen()
    {
        if(y>0)
        {
           x=x+(1*Math.cos(rotation));
           y=y+(1*Math.sin(rotation));
        } 
    }
    
    public void rueckwertsGehen()
    {
        if(y<karte.getSizeY()) //Karte ist eine Klasse, muss noch in ein Objekt umgewandelt werden//
        {
           x=x-(1*Math.cos(rotation));
           y=y-(1*Math.sin(rotation));
        }
    }
    
    public void linksdrehen()
    {
        rotation--;
    }
    
    public void rechtsdrehen()
    {
        rotation++;
    }
    }
 

// Autoren: Martin ; Lasse//
import java.awt.Graphics;
import java.awt.Color;
public class Spieler
{
    private int px; // Postion x (Koordinatensystem)//
    private int py; // Postion y (Koordinatensystem)//
    private String username;
    
    public Spieler(String usernameNeu)
    {
        username= usernameNeu;
        int px = 1;//Startpunkt des Spielers//
        int py = 1;
        
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
        
    }
    
}

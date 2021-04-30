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
        int x = 1;//Startpunkt des Spielers//
        int y = 1;
        int leben = 5;
        
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

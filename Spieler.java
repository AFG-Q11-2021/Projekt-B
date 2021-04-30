// Autoren: Martin ; Lasse//
import java.awt.Graphics;
import java.awt.Color;
public class Spieler
{
    private int px; // Postion x (Koordinatensystem)//
    private int py; // Postion y (Koordinatensystem)//
    private String username;
    
    public Spieler(String usernameNeu, Graphics stift)
    {
        username= usernameNeu;
        int px = 1;//Startpunkt des Spielers//
        int py = 1;

        stift.setColor(farbe);
        stift.fillRect(px, py, 20, 20);
        stift.setColor(Color.BLACK);
        stift.drawRect(px, py, 20, 20);
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

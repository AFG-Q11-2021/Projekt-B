// Autoren: Martin ; Lasse//
public class Spieler
{
    private int px; // Postion x (Koordinatensystem)//
    private int py; // Postion y (Koordinatensystem)//
    private String username;
    
    public Spieler(String usernameNeu)
    {
        username= usernameNeu;
        int px = 1;
        int py = 1;
    }
    
    public void geradeausGehen()
    {
        py--;
    }
    public void ruekwertsGehen()
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
    public Cell getPosition()
    {//Aktualisiert die Position des Spielers//
        
    }
}

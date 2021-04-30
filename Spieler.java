public class Spieler
{
    private int px; // Postion x (Koordinatensystem)//
    private int py; // Postion y (Koordinatensystem)//
    private String username;
    
    public Spieler(String usernameNeu)
    {
        username= usernameNeu;
    }
    
    public void geradeausGehen()
    {
        px++;
    }
    public void rueckwertsGehen()
    {
        px--;
    }
    public Feld getPosition()
    {//Aktualisiert die Position des Spilers//
        
    }
}

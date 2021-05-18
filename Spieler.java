// Autoren: Martin ; Lasse; Laurens//

public class Spieler
{
    private double x; // Postion x (Koordinatensystem)//
    private double y; // Postion y (Koordinatensystem)//
    private double speed;
    private String username;
    private int leben;
    private double rotation;
    private Karte karte;
    
    public Spieler(String usernameNeu)
    {
        username= usernameNeu;
        x = 1;//Startpunkt des Spielers//
        y = 1;//Startpunkt des Spielers//
        leben = 20;
        rotation= 90.0;
        speed = .02f;
    }

    public void linksGehen()
    {
        
    }

    public void rechtsGehen()
    {
        if(y<karte.getSizeX()) //Karte ist eine Klasse, muss noch in ein Objekt umgewandelt werden//
        {
            x=x+(1*Math.cos(rotation+90));
            y=y+(1*Math.sin(rotation+90));
        }
    }

    public void geradeGehen()
    {
        double radrot = Math.toRadians(rotation);
        double xnew = x + speed*(Math.sin(radrot));
        double ynew = y + speed*(Math.cos(radrot));
        
        x = xnew;
        y = ynew;
    }
    
    public void rueckwaertsGehen()
    {
        double radrot = Math.toRadians(rotation);
        double xnew = x - speed*(Math.sin(radrot));
        double ynew = y - speed*(Math.cos(radrot));
        
        x = xnew;
        y = ynew;
    }
    
    
    public void linksdrehen()
    {
        rotation -= 1;
        if(rotation <0){
            rotation += 360;
        }
    }
    
    public void rechtsdrehen()
    {
        rotation += 1;
        if(rotation > 360){
            rotation -= 360;
        }
    }
    
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.y;
    }
    
    public double getRotation(){
        return rotation;
    }
    
    public void Setkarte(Karte k){
        karte = k;
    }
    
    }
 

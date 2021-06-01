// Autoren: Martin ; Lasse; Laurens; Julius//

public class Spieler {
    private double x; // Postion x (Koordinatensystem)//
    private double y; // Postion y (Koordinatensystem)//
    private double speed;
    private String username;
    private int leben;
    private double rotation;

    public Spieler(String usernameNeu, double s) {
        setUsername(usernameNeu);
        x = 5;// Startpunkt des Spielers//
        y = 5;// Startpunkt des Spielers//
        setLeben(20);
        // rotation= 90.0;
        speed =s;
    }
    
    public Spieler(String usernameNeu) {
        setUsername(usernameNeu);
        x = 5;// Startpunkt des Spielers//
        y = 5;// Startpunkt des Spielers//
        setLeben(20);
        // rotation= 90.0;
        speed =0.05;
    }

    public void linksGehen() {

    }

    public void rechtsGehen() {

    }

    public void geradeGehen() {
        double radrot = Math.toRadians(rotation);
        double xnew = x + speed * (Math.sin(radrot));
        double ynew = y + speed * (Math.cos(radrot));

        x = xnew;
        y = ynew;
    }

    public void rueckwaertsGehen() {
        double radrot = Math.toRadians(rotation);
        double xnew = x - speed * (Math.sin(radrot));
        double ynew = y - speed * (Math.cos(radrot));

        x = xnew;
        y = ynew;
    }

    public void linksdrehen() {
        rotation += 1;
        if (rotation < 0) {
            rotation += 360;
        }
    }

    public void rechtsdrehen() {
        rotation -= 1;
        if (rotation > 360) {
            rotation -= 360;
        }
    }

    public double getX() {
        return this.x;
    }
    
    public void setX(double xt) {
        this.x = xt;
    }

    public double getY() {
        return this.y;
    }
    
    public void setY(double yt) {
        this.y = yt;
    }

    public double getRotation() {
        return rotation;
    }
    
    public void setRotation(double rt) {
        this.rotation =rt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLeben() {
        return leben;
    }

    public void setLeben(int leben) {
        this.leben = leben;
    }
    
    public double getSpeed(){
        return speed;
    }
    
    public void setSpeed(double s){
        speed = s;
    }
}
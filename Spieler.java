// Autoren: Martin ; Lasse; Laurens; Julius; Samuel//

public class Spieler {
    private double x, rotation, y, speedm, speedr; // Postion x (Koordinatensystem), Drehung, Postion y
    // (Koordinatensystem), Bewegungsgeschwindigkeit,
    // Drehgeschwindigkeit
    private String username;
    private Karte karte;
    private Weapon[] weapons;
    private Weapon usedWeapon;
    private int leben;

    public Spieler(String usernameNeu, double s, double r, Karte k, Controller c) {
        setUsername(usernameNeu);
        x = 4;// Startpunkt des Spielers//
        y = 3;// Startpunkt des Spielers//
        rotation = 0.0;
        leben = 100;
        speedm = s;
        speedr = r;
        setKarte(k);
        setUsedWeapon(
            new Weapon(10, 100, 0.1, c.getTextureManager().getTexture(3), c.getTextureManager().getTexture(3)));
    }

    public Spieler(String usernameNeu) {
        setUsername(usernameNeu);
        x = 5;// Startpunkt des Spielers//
        y = 5;// Startpunkt des Spielers//
        rotation = 0.0;
        speedm = 0.05;
    }

    public void linksGehen() {
        double radrot = Math.toRadians(rotation + 90);
        double xadd = speedm * (Math.sin(radrot));
        double yadd = speedm * (Math.cos(radrot));
        if (karte.getCoordinate((int) (xadd + x), (int) y) == 0)
            setX(x + xadd);
        if (karte.getCoordinate((int) x, (int) (yadd + y)) == 0)
            setY(y + yadd);
    }

    public void rechtsGehen() {
        double radrot = Math.toRadians(rotation - 90);
        double xadd = speedm * (Math.sin(radrot));
        double yadd = speedm * (Math.cos(radrot));
        if (karte.getCoordinate((int) (x + xadd), (int) y) == 0)
            setX(x + xadd);
        if (karte.getCoordinate((int) x, (int) (yadd + y)) == 0)
            setY(y + yadd);
    }

    public void geradeGehen() {
        double radrot = Math.toRadians(rotation);
        double xadd = speedm * (Math.sin(radrot));
        double yadd = speedm * (Math.cos(radrot));
        if (karte.getCoordinate((int) (xadd + x), (int) y) == 0)
            setX(x + xadd);
        if (karte.getCoordinate((int) x, (int) (yadd + y)) == 0)
            setY(y + yadd);
    }

    public void rueckwaertsGehen() {
        double radrot = Math.toRadians(rotation + 180);
        double xadd = speedm * (Math.sin(radrot));
        double yadd = speedm * (Math.cos(radrot));
        if (karte.getCoordinate((int) (xadd + x), (int) y) == 0)
            setX(x + xadd);
        if (karte.getCoordinate((int) x, (int) (yadd + y)) == 0)
            setY(y + yadd);
    }

    public void linksdrehen() {
        rotation += speedr;
        if (rotation < 0) {
            rotation += 360;
        }
    }

    public void rechtsdrehen() {
        rotation -= speedr;
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
        this.rotation = rt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getSpeed() {
        return speedm;
    }

    public void setSpeed(double s) {
        speedm = s;
    }

    public double getSpeedr() {
        return speedr;
    }

    public void setSpeedr(double speedr) {
        this.speedr = speedr;
    }

    public Karte getKarte() {
        return karte;
    }

    public void setKarte(Karte karte) {
        this.karte = karte;
    }

    public int getLeben() {
        return leben;
    }

    public void setLeben(int l) {
        leben = l;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapon[] weapons) {
        this.weapons = weapons;
    }

    public Weapon getUsedWeapon() {
        return usedWeapon;
    }

    public void setUsedWeapon(Weapon usedWeapon) {
        this.usedWeapon = usedWeapon;
    }

}


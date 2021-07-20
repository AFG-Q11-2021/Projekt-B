
import java.awt.image.*;

/**
 * Write a description of class Weapon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Weapon {
    private BufferedImage standardTexture;
    private BufferedImage shootingTexture;
    private int damagePerBullet;
    private int magazineSize;
    private double timeToReload;
    private double shootDelay;

    public Weapon(int _damagePerBullet, int _magazineSize, double _timeToReload, BufferedImage standardTexture,
            BufferedImage shootingTexture) {
        setDamagePerBullet(_damagePerBullet);
        setMagazineSize(_magazineSize);
        setTimeToReload(_timeToReload);
        this.setStandardTexture(standardTexture);
        this.setShootingTexture(shootingTexture);
    }

    public BufferedImage getStandardTexture() {
        return standardTexture;
    }

    public void setStandardTexture(BufferedImage standardTexture) {
        this.standardTexture = standardTexture;
    }

    public BufferedImage getShootingTexture() {
        return shootingTexture;
    }

    public void setShootingTexture(BufferedImage shootingTexture) {
        this.shootingTexture = shootingTexture;
    }

    public int getDamagePerBullet() {
        return damagePerBullet;
    }

    public void setDamagePerBullet(int damagePerBullet) {
        this.damagePerBullet = damagePerBullet;
    }

    public int getMagazineSize() {
        return magazineSize;
    }

    public void setMagazineSize(int magazineSize) {
        this.magazineSize = magazineSize;
    }

    public double getTimeToReload() {
        return timeToReload;
    }

    public void setTimeToReload(double timeToReload) {
        this.timeToReload = timeToReload;
    }

    public double getShootDelay() {
        return shootDelay;
    }

    public void setShootDelay(double shootDelay) {
        this.shootDelay = shootDelay;
    }
}

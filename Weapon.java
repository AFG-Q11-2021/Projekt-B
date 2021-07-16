import java.awt.*;
import java.awt.image.*;
import java.util.*;
import java.sql.*;

/**
 * Write a description of class Weapon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Weapon
{
    private BufferedImage standardTexture;
    private BufferedImage shootingTexture;
    private int damagePerBullet;
    private int magazineSize;
    private double timeToReload;
    private double shootDelay;

    public Weapon(int _damagePerBullet, int _magazineSize,double _timeToReload,BufferedImage standardTexture, BufferedImage shootingTexture){
        damagePerBullet = _damagePerBullet;
        magazineSize = _magazineSize;
        double timeToReload = _timeToReload;
        this.standardTexture = standardTexture;
        this.shootingTexture = shootingTexture;
    }

    public BufferedImage getStandardTexture(){
        return standardTexture;
    }
    
    public BufferedImage getShootingTexture(){
        return shootingTexture;
    }
    
    public int getDamagePerBullet(){
        return damagePerBullet;
    }
    
    public double getShootDelay(){
        return shootDelay;
    }
    
    public double getTimeToReload(){
        return timeToReload;
    }
    
}

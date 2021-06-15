import java.util.*;
import java.awt.*;

public class Entity
{
<<<<<<< HEAD
    private float x,y;
    private float rotation;  
    private int texID;
    
    public float getX(){
        return x;
    }
    public float getY(){
=======
    private double x,y;
    private int texID;
    
    public Entity(double x, double y, int texID){
        this.x = x;
        this.y = y;
        this.texID = texID;
    }
    
    public double getX(){
        return x;
    }
    public double getY(){
>>>>>>> e20e99bef41e37992f75113edfa4de68172f9e00
        return y;
    }
    public int getTexID(){
        return texID;
    }
}

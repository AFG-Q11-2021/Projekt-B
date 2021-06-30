public class Entity
{
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
        return y;
    }
    
    public int getTexID(){
        return texID;
    }
}


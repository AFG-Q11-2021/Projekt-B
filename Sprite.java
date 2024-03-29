//Author: Laurens Birkenbach  - 18.06.2021

import java.awt.image.*;

public class Sprite
{
    public double x, y, rotation;
    private int playerID;
    public BufferedImage[] textures;
    private boolean directional;
    private int numSprites;
    private String name;


    public Sprite(double x, double y, String name, double rotation, int playerID ,boolean directional, BufferedImage... textures){
        this.playerID = playerID;
        this.x = x;
        this.y = y;
        this.name = name;
        this.rotation = rotation;
        this.directional = directional;
        this.textures = textures;
        numSprites = textures.length;
    }
    
    public Sprite(Spieler s, int playerID ,boolean directional, BufferedImage... textures){
        this.playerID = playerID;
        this.x = s.getX();
        this.y = s.getY();
        this.name = s.getUsername();
        this.rotation = s.getRotation();
        this.directional = directional;
        this.textures = textures;
        numSprites = textures.length;
    }

    public String getName(){
        return name;
    }

    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public double getRotation(){
        return rotation;
    }

    public void move(double x, double y){
        this.x = x;
        this.y = y;
    }

    public BufferedImage getDirectTexture(double camX,double camY){
        if(!directional){
            // System.out.println("not directional");
            return textures[0];

        }
        double dx = camX-x;
        double dy = camY-y;
        double angle =   Math.atan2(dx,dy) + 3.14159;
        int texIndex =  Math.round((float)((numSprites*angle)/6.283)) ;
        //System.out.println(texIndex);
        if(texIndex == numSprites){
            return textures[0];   
        }
        return textures[texIndex];

    }
    
    public int getID(){
        return this.playerID;
    }

}

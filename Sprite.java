//Author: Laurens Birkenbach  - 18.06.2021

import java.awt.image.*;

public class Sprite
{
    public double x, y;
    private int playerID;
    public BufferedImage[] textures;
    private boolean directional;
    private int numSprites;
    
    public Sprite(double x, double y, String name, double rotation, int playerID ,boolean directional, BufferedImage... textures){
        this.playerID = playerID;
        this.x = x;
        this.y = y;
        this.directional = directional;
        this.textures = textures;
        numSprites = textures.length;
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

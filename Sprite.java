//Author: Laurens Birkenbach  - 18.06.2021

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Sprite
{
    public double x, y;

    private BufferedImage[] textures;
    private boolean directional;

    public Sprite(double x, double y,boolean directional, BufferedImage... textures){
        this.x = x;
        this.y = y;
        this.directional = directional;
        this.textures = textures;
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
        int texIndex =  Math.round((float)((8*angle)/6.283)) ;
        //System.out.println(texIndex);
        if(texIndex == 8){
            return textures[0];   
        }
        return textures[texIndex];

        
    }

}

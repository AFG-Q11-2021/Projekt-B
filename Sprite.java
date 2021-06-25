//Author: Laurens Birkenbach  - 18.06.2021

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Sprite
{
    public double x;
    public double y;

    private BufferedImage[] textures;
    private boolean directional;

    public Sprite(double x, double y,boolean directional, BufferedImage... textures){
        this.x = x;
        this.y = y;
        this.directional = false;
        this.textures = textures;
    }

    public void move(double x, double y){
        this.x = x;
        this.y = y;
    }

    public BufferedImage getDirectTexture(){
        return textures[0];
    }
}

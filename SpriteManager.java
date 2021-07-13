import java.awt.*;
import java.awt.image.*;
import java.util.*;
import java.sql.*;

public class SpriteManager
{
    private Sprite[] sprites;

    public SpriteManager(Controller c){
        sprites = new Sprite[42];
        TextureManager texManager = c.getTextureManager();
        
        sprites[0]= new Sprite(15,15,0,true,texManager.getSpriteTexture(16),texManager.getSpriteTexture(15),
        texManager.getSpriteTexture(14),texManager.getSpriteTexture(13),texManager.getSpriteTexture(12),
        texManager.getSpriteTexture(11),texManager.getSpriteTexture(10),texManager.getSpriteTexture(9));

    }

    public  BufferedImage[] returnTextureSet(int spriteID){
        return sprites[spriteID].textures;
    }

}

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class TextureManager
{
    private BufferedImage[] textures;
    private BufferedImage[] darkTextures;
    
    private BufferedImage[] skyTextures;
    
    public TextureManager(){
        textures = new BufferedImage[10];
        darkTextures = new BufferedImage[10];
        skyTextures = new BufferedImage[10];
        
        loadTexture(0,"textures/sheetMetal.png");
        loadSkyTexture(0,"textures/sky.png");
        createDarkTexture(0);
    }
    
    public BufferedImage getTexture(int texID){
        return textures[texID];
    }
    
    public BufferedImage getSkyTexture(int texID){
        return skyTextures[texID];
    }
    
    public BufferedImage getDarkTexture(int texID){
        return darkTextures[texID];
    }
    
    private void loadTexture(int index, String path){
          try
        {
            textures[index] = ImageIO.read(new File(path));
        }
        catch (java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    private void loadSkyTexture(int index, String path){
          try
        {
            skyTextures[index] = ImageIO.read(new File(path));
        }
        catch (java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    private void createDarkTexture(int texID){
        int texRes = textures[texID].getWidth(null);
         BufferedImage bi = new BufferedImage(texRes,texRes,BufferedImage.TYPE_INT_ARGB);
                Graphics j = bi.getGraphics();
                j.drawImage(textures[texID],0,0,null);
                float dark = 0.6f;
                float[] scales = { dark, dark, dark, 1f};
                float[] offsets = new float[4];
                RescaleOp rop = new RescaleOp(scales, offsets, null);
                bi = rop.filter(bi,null);
                darkTextures[texID] = bi;
    }
}

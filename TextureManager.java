import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class TextureManager
{
    private BufferedImage[] textures;
    
    public TextureManager(){
        textures = new BufferedImage[10];
        loadTexture(0,"textures/test.png");
      
    }
    
    public Image getTexture(int texID){
        return textures[texID];
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
}

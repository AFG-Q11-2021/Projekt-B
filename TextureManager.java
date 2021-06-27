import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
//Author: Laurens
public class TextureManager {
    private BufferedImage[] textures, darkTextures, skyTextures, spriteTextures;

    public TextureManager() {
        textures = new BufferedImage[100];
        darkTextures = new BufferedImage[100];
        skyTextures = new BufferedImage[10];
        spriteTextures = new BufferedImage[20];

        loadSkyTexture(0, "textures/sky.png");

        loadTexture(0, "textures/sheetMetal.png");
        createDarkTexture(0);

        loadTexture(1, "textures/brickWall.png");
        createDarkTexture(1);

        loadTexture(2, "textures/brickWallPainting.png");
        createDarkTexture(2);

        loadTexture(3, "textures/woodPlankWall.png");
        createDarkTexture(3);

        loadTexture(4, "textures/brickWallPainting Hr.Wolf.png");
        createDarkTexture(4);

        loadTexture(5, "textures/brickWall.png");
        createDarkTexture(5);

        loadTexture(6, "textures/brickWallBloodVariation1.png");
        createDarkTexture(6);

        loadTexture(7, "textures/brickWallBloodVariation2.png");
        createDarkTexture(7);

        loadTexture(8, "textures/brickWalltotenkopf.png");
        createDarkTexture(8);

        loadTexture(9, "textures/woodPlankWallblood.png");
        createDarkTexture(9);

        loadTexture(10, "textures/teppichBoden.png");
        createDarkTexture(10);

        loadTexture(11, "textures/brickWallredandbluefusion.png");
        createDarkTexture(11);
        
        
        //Sprite Textures
        
        loadSpriteTexture(0, "textures/explosiveBarrel.png");
        loadSpriteTexture(1, "textures/testHuman01.png");
        loadSpriteTexture(2, "textures/testHuman02.png");
        loadSpriteTexture(3, "textures/testHuman03.png");
        loadSpriteTexture(4, "textures/testHuman04.png");
        loadSpriteTexture(5, "textures/testHuman05.png");
        loadSpriteTexture(6, "textures/testHuman06.png");
        loadSpriteTexture(7, "textures/testHuman07.png");
        loadSpriteTexture(8, "textures/testHuman08.png");
        
        loadSpriteTexture(9 , "textures/barrel01.png");
        loadSpriteTexture(10, "textures/barrel02.png");
        loadSpriteTexture(11, "textures/barrel03.png");
        loadSpriteTexture(12, "textures/barrel04.png");
        loadSpriteTexture(13, "textures/barrel05.png");
        loadSpriteTexture(14, "textures/barrel06.png");
        loadSpriteTexture(15, "textures/barrel07.png");
        loadSpriteTexture(16, "textures/barrel08.png");
        
        
        
        

    }

    public BufferedImage getTexture(int texID) {
        return textures[texID];
    }

    public BufferedImage getSkyTexture(int texID) {
        return skyTextures[texID];
    }
    
     public BufferedImage getSpriteTexture(int texID) {
        return spriteTextures[texID];
    }

    public BufferedImage getDarkTexture(int texID) {
        return darkTextures[texID];
    }

    private void loadTexture(int index, String path) {
        try {
            textures[index] = ImageIO.read(new File(path));
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
      private void loadSpriteTexture(int index, String path) {
        try {
            spriteTextures[index] = ImageIO.read(new File(path));
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void loadSkyTexture(int index, String path) {
        try {
            skyTextures[index] = ImageIO.read(new File(path));
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void createDarkTexture(int texID) {
        int texRes = textures[texID].getWidth();
        BufferedImage bi = new BufferedImage(texRes, texRes, BufferedImage.TYPE_INT_ARGB);
        Graphics j = bi.getGraphics();
        j.drawImage(textures[texID], 0, 0, null);
        float dark = 0.4f;
        float[] scales = { dark, dark, dark, 1f };
        float[] offsets = new float[4];
        RescaleOp rop = new RescaleOp(scales, offsets, null);
        bi = rop.filter(bi, null);
        darkTextures[texID] = bi;
    }
}

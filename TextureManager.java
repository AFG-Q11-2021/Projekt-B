import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
//Author: Laurens
public class TextureManager {
    private BufferedImage[] textures, darkTextures, skyTextures;

    public TextureManager() {
        textures = new BufferedImage[10];
        darkTextures = new BufferedImage[10];
        skyTextures = new BufferedImage[10];

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
<<<<<<< HEAD
<<<<<<< HEAD
        
        loadTexture(5, "textures/brickWallSchwanzSecret.png");
        createDarkTexture(5);
=======

        loadTexture(5, "textures/brickWallSchwanzSecret.png");
        createDarkTexture(5);

        loadTexture(6, "textures/brickWallBloodVariation1.png");
        createDarkTexture(6);

        loadTexture(7, "textures/brickWallBloodVariation2.png");
        createDarkTexture(7);

        loadTexture(8, "textures/brickWalltotenkopf.png");
        createDarkTexture(8);

>>>>>>> 39b582e024dbe5a678dafd700214cf0e55956daa
=======

        loadTexture(5, "textures/brickWallSchwanzSecret.png");
        createDarkTexture(5);

        loadTexture(6, "textures/brickWallBloodVariation1.png");
        createDarkTexture(6);

        loadTexture(7, "textures/brickWallBloodVariation2.png");
        createDarkTexture(7);

        loadTexture(8, "textures/brickWalltotenkopf.png");
        createDarkTexture(8);

>>>>>>> 39b582e024dbe5a678dafd700214cf0e55956daa
    }

    public BufferedImage getTexture(int texID) {
        return textures[texID];
    }

    public BufferedImage getSkyTexture(int texID) {
        return skyTextures[texID];
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

    private void loadSkyTexture(int index, String path) {
        try {
            skyTextures[index] = ImageIO.read(new File(path));
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void createDarkTexture(int texID) {
        int texRes = textures[texID].getWidth(null);
        BufferedImage bi = new BufferedImage(texRes, texRes, BufferedImage.TYPE_INT_ARGB);
        Graphics j = bi.getGraphics();
        j.drawImage(textures[texID], 0, 0, null);
        float dark = 0.6f;
        float[] scales = { dark, dark, dark, 1f };
        float[] offsets = new float[4];
        RescaleOp rop = new RescaleOp(scales, offsets, null);
        bi = rop.filter(bi, null);
        darkTextures[texID] = bi;
    }
}

//Author of the System: Julius R and Samuel T
//only the Caster should be called from the outside
//to tell the caster which map to use go to...
import Java.util;
public class Raycaster
{
    public KartenVerwaĺter karte;
    public Game verwalter;
    private int texWidth = 64, texHeight = 64;
    public Raycaster(KartenVerwalter tempKarte, Controller con)
    {
        karte = tempkarte;
        verwalter = con.Getgame();
    }

    public void update()
    {
        double posX = 22.0, posY = 11.5;  //x and y start position
        double dirX = -1.0, dirY = 0.0; //initial direction vector
        double planeX = 0.0, planeY = 0.66; //the 2d raycaster version of camera plane

        double time = 0; //time of current frame
        double oldTime = 0; //time of previous frame

        int[][] buffer = new int[screenHeight][screenWidth]; // y-coordinate first because it works per scanline
        Vector<int> texture = new Vector<int>(8);
        for(int i = 0; i < 8; i++)
        {
            texture[i].setSize(texWidth * texHeight);
        }
        screen(screenWidth,screenHeight, 0, "Raycaster");

        //generate some textures
        for(int x = 0; x < texWidth; x++)
            for(int y = 0; y < texHeight; y++)
            {
                int xorcolor = (x * 256 / texWidth) ^ (y * 256 / texHeight);
                //int xcolor = x * 256 / texWidth;
                int ycolor = y * 256 / texHeight;
                int xycolor = y * 128 / texHeight + x * 128 / texWidth;
                texture[0][texWidth * y + x] = 65536 * 254 * (x != y && x != texWidth - y); //flat red texture with black cross
                texture[1][texWidth * y + x] = xycolor + 256 * xycolor + 65536 * xycolor; //sloped greyscale
                texture[2][texWidth * y + x] = 256 * xycolor + 65536 * xycolor; //sloped yellow gradient
                texture[3][texWidth * y + x] = xorcolor + 256 * xorcolor + 65536 * xorcolor; //xor greyscale
                texture[4][texWidth * y + x] = 256 * xorcolor; //xor green
                texture[5][texWidth * y + x] = 65536 * 192 * (x % 16 && y % 16); //red bricks
                texture[6][texWidth * y + x] = 65536 * ycolor; //red gradient
                texture[7][texWidth * y + x] = 128 + 256 * 128 + 65536 * 128; //flat grey texture
            }
    }



import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;

/*Autor: Laurens Birkenbach
 * Zuletzt geändert: 23.05.2021
 * Inhalt: Raycasting-Logik, wird von Singleplayergame / Multiplayergame aufgerufen
 */
public class CastTest {
    public static void paintMap(Graphics g, Karte k, Spieler s) {
        int stepSize = 1;
        int texRes = 32;

        double xPos = s.getX();
        double yPos = s.getY();
        double rot = Math.toRadians(-s.getRotation());

        double dirX = 0;
        double dirY = 1;

        double oldDirX = dirX;
        dirX = dirX * Math.cos(rot) - dirY * Math.sin(rot);
        dirY = oldDirX * Math.sin(rot) + dirY * Math.cos(rot);

        double planeX = 0.66;
        double planeY = 0;

        
        double oldPlaneX = planeX;
        planeX = planeX * Math.cos(rot) - planeY * Math.sin(rot);
        planeY = oldPlaneX * Math.sin(rot) + planeY * Math.cos(rot);

        Game game = Controller.getGame();

        int screenWidth = game.getWidth();
        int screenHeight = game.getHeight();

        //drawSky
        float fov = 52.85f;
        int sourceWidth = (int) ((fov/360)*1000);
        for(int dx = 0; dx < game.getWidth()/stepSize;dx++){
            int x = dx * stepSize;
            double camX = (2 * x / ((double) game.getWidth())) - 1;

            double rayAngle = (rot + (camX*0.583));

            int texX = (int) ((rayAngle/6.283) * 1000);
            if(texX < 0) texX += 1000;
            if(texX > 1000) texX -= 1000;

            g.drawImage(Controller.getTextureManager().getSkyTexture(0),x-stepSize-1,0,x+stepSize ,game.getHeight(),
                texX,100,texX+1,250,null);

        }

         g.setColor(new Color(90, 90, 90));
         g.fillRect(0, game.getHeight() / 2, game.getWidth(), game.getHeight() / 2);

        //Floor Casting?
        BufferedImage floorImage = new BufferedImage(screenWidth,screenHeight/2 +1,BufferedImage.TYPE_INT_RGB);
        for(int iy = game.getHeight()/(2*stepSize); iy < game.getHeight()/stepSize;iy++){
            // rayDir for leftmost ray (x = 0) and rightmost ray (x = w)
            int y = iy*stepSize;
            double rayDirX0 = dirX - planeX;
            double rayDirY0 = dirY - planeY;
            double rayDirX1 = dirX + planeX;
            double rayDirY1 = dirY + planeY;

            int p = y - game.getHeight()/2;
            double posZ = 0.5 *game.getHeight();

            double rowDistance = posZ/p;

            // calculate the real world step vector we have to add for each x (parallel to camera plane)
            // adding step by step avoids multiplications with a weight in the inner loop
            double floorStepX = rowDistance * (rayDirX1 - rayDirX0) / screenWidth;
            double floorStepY = rowDistance * (rayDirY1 - rayDirY0) / screenWidth;

            // real world coordinates of the leftmost column. This will be updated as we step to the right.
            double floorX = xPos + rowDistance * rayDirX0;
            double floorY = yPos + rowDistance * rayDirY0;

            for(int ix = 0; ix < screenWidth/stepSize; ++ix)
            {
                int x = ix*stepSize;
                // the cell coord is simply got from the integer parts of floorX and floorY
                
                int cellX = (int)(floorX);
                int cellY = (int)(floorY);

                // get the texture coordinate from the fractional part
                int tx = (int)(texRes * (floorX - cellX)) & (texRes - 1);
                int ty = (int)(texRes * (floorY - cellY)) & (texRes - 1);

                floorX += floorStepX;
                floorY += floorStepY;

                // choose texture and draw the pixel

                // floor
                //color = texture[floorTexture][texRes * ty + tx];
                //color = (color >> 1) & 8355711; // make a bit darker
               // buffer[y][x] = color;
                int drawX = screenWidth-x;
                
                Color c = new Color(Controller.getTextureManager().getDarkTexture(0).getRGB(tx,ty));
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                int rgb = red;
                rgb = (rgb<<8) + green;
                rgb = (rgb<<8) + blue;
                
                floorImage.setRGB(x,y-screenHeight/2,rgb);
                // g.drawImage(Controller.getTextureManager().getDarkTexture(0),drawX,y,drawX+stepSize ,y+stepSize,
                //tx,ty,tx+1,ty+1,null);
                

                //ceiling (symmetrical, at screenHeight - y - 1 instead of y)
                //color = texture[ceilingTexture][texRes * ty + tx];
                // color = (color >> 1) & 8355711; // make a bit darker
                // buffer[screenHeight - y - 1][x] = color;
            }
            
        }
        g.drawImage(floorImage,0,screenHeight/2,null);

        //WallCasting
        for (int fx = 0; fx < game.getWidth()/stepSize; fx++) {
            int x = fx * stepSize;
            double camX = (2 * x / ((double) game.getWidth())) - 1;
            double rayDirX = dirX + planeX * camX;
            double rayDirY = dirY + planeY * camX;

            int mapX = (int) xPos;
            int mapY = (int) yPos;

            double sideDistX;
            double sideDistY;

            double deltaDistX = (rayDirY == 0) ? 0 : ((rayDirX == 0) ? 1 : Math.abs(1 / rayDirX));
            double deltaDistY = (rayDirX == 0) ? 0 : ((rayDirY == 0) ? 1 : Math.abs(1 / rayDirY));

            double perpWallDist;

            int stepX;
            int stepY;

            int hit = 0;
            int side = 0;

            if (rayDirX < 0) {
                stepX = -1;
                sideDistX = (xPos - mapX) * deltaDistX;
            } else {
                stepX = 1;
                sideDistX = (mapX + 1.0 - xPos) * deltaDistX;
            }
            if (rayDirY < 0) {
                stepY = -1;
                sideDistY = (yPos - mapY) * deltaDistY;
            } else {
                stepY = 1;
                sideDistY = (mapY + 1.0 - yPos) * deltaDistY;
            }

            // cast
            while (hit == 0) {
                if (sideDistX < sideDistY) {
                    sideDistX += deltaDistX;
                    mapX += stepX;
                    side = 0;
                } else {
                    sideDistY += deltaDistY;
                    mapY += stepY;
                    side = 1;
                }
                if (mapX >= k.getSizeX() - 1 || mapX < 0 || mapY >= k.getSizeY() - 1 || mapY < 0) {
                    break;
                }
                if (k.getCoordinate(mapX, mapY) > 0) {
                    hit = 1;
                }
            }

            if (side == 0)
                perpWallDist = (mapX - xPos + (1 - stepX) / 2) / rayDirX;
            else
                perpWallDist = (mapY - yPos + (1 - stepY) / 2) / rayDirY;

            int columnHeight = (int) (game.getHeight() / perpWallDist);
            int topPixel = (game.getHeight() - columnHeight) / 2;

            // if (mapX >= k.getSizeX() - 1 || mapX < 0 || mapY >= k.getSizeY() - 1 || mapY < 0) {
            //     break;
            // }
            int texID = k.getCoordinate(mapX,mapY) -1;

            //calculate value of wallX
            double wallX; //where exactly the wall was hit
            if (side == 0) wallX = yPos + perpWallDist * rayDirY;
            else           wallX = xPos + perpWallDist * rayDirX;
            wallX -= Math.floor((wallX));

            //x coordinate on the texture
            int texX = (int) (wallX * texRes);
            if(side == 0 && rayDirX > 0) texX = texRes - texX - 1;
            if(side == 1 && rayDirY < 0) texX = texRes - texX - 1;

            texX = texRes-texX-1;
            int xdraw = game.getWidth() - x;
            BufferedImage imgRaw = Controller.getTextureManager().getTexture(texID);

            if (side == 1) {
                g.drawImage(imgRaw,xdraw-stepSize-1,topPixel,xdraw+stepSize ,topPixel + columnHeight,
                    texX,0,texX+1,texRes,null);
            } else {
                g.drawImage(Controller.getTextureManager().getDarkTexture(texID),xdraw-stepSize-1,topPixel,xdraw+stepSize ,topPixel + columnHeight,
                    texX,0,texX+1,texRes,null);
            }

            // g.fillRect(xdraw, topPixel, 1, columnHeight);
        }
    }

}

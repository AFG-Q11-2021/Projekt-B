
import java.awt.*;
import java.util.*;
    /*Autor: Laurens Birkenbach
     * Zuletzt geändert: 23.05.2021
     * Inhalt: Raycastng-Logik, wird von Singleplayergame / Multiplayergame aufgerufen
 */
public class CastTest
{
    public static void paintMap(Graphics g,Karte k, Spieler s){
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

        
        Game game = Controller.Getgame();
        g.setColor(new Color(180,70,0));
        g.fillRect(0,game.getHeight()/2,game.getWidth(),game.getHeight()/2);

        for(int x = 0; x < game.getWidth();x++){
            double camX = (2 * x/ ((double) game.getWidth())) - 1;
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

            if(rayDirX < 0){
                stepX = -1;
                sideDistX = (xPos - mapX) * deltaDistX;
            }
            else{
                stepX = 1;
                sideDistX = (mapX + 1.0 - xPos) * deltaDistX;
            }
            if(rayDirY < 0){
                stepY = -1;
                sideDistY = (yPos - mapY) * deltaDistY;
            }
            else{
                stepY = 1;
                sideDistY = (mapY + 1.0 - yPos) * deltaDistY;
            }

            //cast
            while(hit == 0){
                if(sideDistX < sideDistY){
                    sideDistX += deltaDistX;
                    mapX += stepX;
                    side = 0;
                }
                else {
                    sideDistY += deltaDistY;
                    mapY += stepY;
                    side = 1;
                }
                if(mapX >= k.getSizeX()-1 ||mapX < 0 || mapY >= k.getSizeY()-1 ||mapY < 0) {break;}
                if(k.getCoordinate(mapX,mapY) > 0){
                    hit = 1;
                }
            }

            if (side == 0) perpWallDist = (mapX - xPos + (1 - stepX) / 2) / rayDirX;
            else           perpWallDist = (mapY - yPos + (1 - stepY) / 2) / rayDirY;

            int columnHeight = (int) (game.getHeight()/perpWallDist);
            int topPixel = (game.getHeight()-columnHeight)/2;

            if(topPixel < 0) topPixel = 0;
            if(side == 1){
                g.setColor(new Color(40,40,40));
            } else {
                g.setColor(new Color(60,60,60));
            }
            g.fillRect(game.getWidth() - x,topPixel,1,columnHeight);
        }
    }

}   


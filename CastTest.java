import java.awt.*;
import java.awt.image.*;
import java.util.*;
import java.sql.*;

/*Autor: Laurens Birkenbach, Julius
 * Zuletzt geändert: 30.06.2021
 * Inhalt: Raycasting-Logik, wird von Singleplayergame / Multiplayergame aufgerufen
 */
public class CastTest   {
    private Controller con;
    private Game game;
    private TextureManager texManager;
    private int stepSize, floorRes, texRes, screenWidth, screenHeight, spriteResX, spriteResY;
    private double[] depthBuffer = new double[screenWidth];
    private double yPos, xPos, dirX, dirY, planeX, planeY, rot, oldPlaneX;
    private boolean run = false;
    private ArrayList<Sprite> sprites;
    private int hitID = -1;
    private Sprite lastsprite;

    private int[] floorTextureDark;
    private int[] floorTexture;

    public CastTest(Controller c) {
        sprites = new ArrayList<Sprite>();
        con = c;
        texManager = con.getTextureManager();
        stepSize = 4;
        floorRes = 4;
        texRes = 32;
        spriteResX = 64;
        spriteResY = 64;
        oldPlaneX = 0.66;
        floorTexture = new int[texRes*texRes];
        floorTextureDark = new int[texRes*texRes];
    }

    private void paintPlayers(Spieler sp) {
        Spieler h;
        sprites.clear();
        Connection verbindung = null;
        String sql2 = "SELECT name, xposition, yposition, rotation, ID FROM multiplayer WHERE name !='" + sp.getUsername() + "'";
        verbindung = aufbau(verbindung);
        try {
            Statement st = verbindung.createStatement();
            ResultSet ergebnis = st.executeQuery(sql2);
            while (ergebnis.next()) {
                h = new Spieler(ergebnis.getString(1));
                h.setX(ergebnis.getDouble(2));
                h.setY(ergebnis.getDouble(3));
                h.setRotation(ergebnis.getDouble(4));
                Sprite af = new Sprite(ergebnis.getDouble(2),ergebnis.getDouble(3),ergebnis.getString(1),ergebnis.getDouble(4),
                    ergebnis.getInt(5),true,texManager.getSpriteTexture(8),texManager.getSpriteTexture(7),
                    texManager.getSpriteTexture(6),texManager.getSpriteTexture(5),texManager.getSpriteTexture(4),
                    texManager.getSpriteTexture(3),texManager.getSpriteTexture(2),texManager.getSpriteTexture(1));
                sprites.add(af);
            }
            ergebnis.close();
            st.close();
            abbau(verbindung);
        } catch (Exception e) {
            System.err.println("Fehler beim Auslesen der Datenbank: " + e);
            System.exit(0);
        }
    }

    public void drawGUI(Graphics g, Spieler s){
        g.drawImage(texManager.getGuiTexture(0),100,100,null);
    }

    public void paintMap(Graphics g, Karte k, Spieler s) {
        if(run){
            xPos = s.getX();
            yPos = s.getY();
            rot = Math.toRadians(-s.getRotation());

            dirY = 1;
            dirX =  - dirY * Math.sin(rot);//Spielerrotation einrechnen(Blickrichtung)
            dirY = dirY * Math.cos(rot);

            planeX = oldPlaneX * Math.cos(rot);//Spielerrotation einrechnen(Lot auf Blickrichtung
            planeY = oldPlaneX * Math.sin(rot);

            // drawSky
            drawSky(g);

            // Floor Casting?
            floorCasting(g,k);

            // draw Entities (Enemies, Props, Pickups)
            int x, mapX, mapY, stepX, stepY, xdraw, texX, hit, side, texID;
            double wallX, perpWallDist, sideDistX, sideDistY;
            for (int fx = 0; fx < screenWidth / stepSize; fx++) {
                x = fx * stepSize;
                double camX = (2.0 * x / screenWidth) - 1;
                double rayDirX = dirX + planeX * camX;
                double rayDirY = dirY + planeY * camX;

                mapX = (int) xPos;
                mapY = (int) yPos;

                double deltaDistX = (rayDirY == 0) ? 0 : ((rayDirX == 0) ? 1 : Math.abs(1 / rayDirX));
                double deltaDistY = (rayDirX == 0) ? 0 : ((rayDirY == 0) ? 1 : Math.abs(1 / rayDirY));

                hit = 0;
                side = 0;

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
                while ( hit == 0 ){
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

                int columnHeight = (int) (screenHeight / perpWallDist);
                int topPixel = (screenHeight - columnHeight) / 2;

                texID = k.getCoordinate(mapX, mapY) - 1;

                // calculate value of wallX
                // where exactly the wall was hit
                if (side == 0)
                    wallX = yPos + perpWallDist * rayDirY;
                else
                    wallX = xPos + perpWallDist * rayDirX;
                wallX -= Math.floor(wallX);

                // x coordinate on the texture
                texX = (int) (wallX * texRes);
                if (side == 0 && rayDirX > 0)
                    texX = texRes - texX - 1;
                if (side == 1 && rayDirY < 0)
                    texX = texRes - texX - 1;

                texX = texRes - texX - 1;
                xdraw = screenWidth - x;
                if (side == 1) {
                    g.drawImage(texManager.getTexture(texID), xdraw - stepSize - 1, topPixel, xdraw + stepSize ,
                        topPixel + columnHeight, texX, 0, texX + 1, texRes, null);
                } else {
                    g.drawImage(texManager.getDarkTexture(texID), xdraw - stepSize - 1, topPixel, xdraw +stepSize,
                        topPixel + columnHeight, texX, 0, texX + 1, texRes, null);
                }
                for(int i = 0; i < stepSize;i++){
                    depthBuffer[x + i] = perpWallDist;
                }

            }   
            sortSprites();
            drawSprites(g);
        }
    }
    
    public void paintMapMulti(Graphics g, Karte k, Spieler s) {
        if(run){
            xPos = s.getX();
            yPos = s.getY();
            rot = Math.toRadians(-s.getRotation());

            dirY = 1;
            dirX =  - dirY * Math.sin(rot);//Spielerrotation einrechnen(Blickrichtung)
            dirY = dirY * Math.cos(rot);

            planeX = oldPlaneX * Math.cos(rot);//Spielerrotation einrechnen(Lot auf Blickrichtung
            planeY = oldPlaneX * Math.sin(rot);

            // drawSky
           // drawSky(g);

            // Floor Casting?
            floorCasting(g,k);

            // draw Entities (Enemies, Props, Pickups)
            int x, mapX, mapY, stepX, stepY, xdraw, texX, hit, side, texID;
            double wallX, perpWallDist, sideDistX, sideDistY;
            for (int fx = 0; fx < screenWidth / stepSize; fx++) {
                x = fx * stepSize;
                double camX = (2.0 * x / screenWidth) - 1;
                double rayDirX = dirX + planeX * camX;
                double rayDirY = dirY + planeY * camX;

                mapX = (int) xPos;
                mapY = (int) yPos;

                double deltaDistX = (rayDirY == 0) ? 0 : ((rayDirX == 0) ? 1 : Math.abs(1 / rayDirX));
                double deltaDistY = (rayDirX == 0) ? 0 : ((rayDirY == 0) ? 1 : Math.abs(1 / rayDirY));

                hit = 0;
                side = 0;

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
                while ( hit == 0 ){
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

                int columnHeight = (int) (screenHeight / perpWallDist);
                int topPixel = (screenHeight - columnHeight) / 2;

                texID = k.getCoordinate(mapX, mapY) - 1;

                // calculate value of wallX
                // where exactly the wall was hit
                if (side == 0)
                    wallX = yPos + perpWallDist * rayDirY;
                else
                    wallX = xPos + perpWallDist * rayDirX;
                wallX -= Math.floor(wallX);

                // x coordinate on the texture
                texX = (int) (wallX * texRes);
                if (side == 0 && rayDirX > 0)
                    texX = texRes - texX - 1;
                if (side == 1 && rayDirY < 0)
                    texX = texRes - texX - 1;

                texX = texRes - texX - 1;
                xdraw = screenWidth - x;
                if (side == 1) {
                    g.drawImage(texManager.getTexture(texID), xdraw - stepSize - 1, topPixel, xdraw + stepSize ,
                        topPixel + columnHeight, texX, 0, texX + 1, texRes, null);
                } else {
                    g.drawImage(texManager.getDarkTexture(texID), xdraw - stepSize - 1, topPixel, xdraw +stepSize,
                        topPixel + columnHeight, texX, 0, texX + 1, texRes, null);
                }
                for(int i = 0; i < stepSize;i++){
                    depthBuffer[x + i] = perpWallDist;
                }

            }   
            paintPlayers(s);
            sortSprites();
            drawSprites(g);
        }
    }

    private void sortSprites(){
        Collections.sort(sprites, new Comparator<Sprite>() {
                @Override
                public int compare(Sprite s1, Sprite s2){
                    double dsts1 = (xPos - s1.x)*(xPos - s1.x) + (yPos - s1.y)*(yPos - s1.y);
                    double dsts2 = (xPos - s2.x)*(xPos - s2.x) + (yPos - s2.y)*(yPos - s2.y);

                    return new Double(dsts2).compareTo(dsts1);
                }
            }
        );
    }

    private void drawSprites(Graphics g){
        double spriteX, spriteY, inverse, tranX, tranY;
        int spritePixelX, drawHeight, startDrawY, endDrawY, drawWidth, startDrawX, endDrawX;

        for(Sprite s:sprites){

            spriteX = s.x - xPos;
            spriteY = s.y - yPos;
            
             double dsts1 = (xPos - s.x)*(xPos - s.x) + (yPos - s.y)*(yPos - s.y);
            if(dsts1 < 1){
                continue;
            }
            inverse = 1 / (planeX*dirY - dirX*planeY);

            
            tranX = inverse * (dirY*spriteX - dirX *spriteY);
            tranY = inverse * (-planeY*spriteX + planeX*spriteY);

            spritePixelX = (int) ((screenWidth/2) * (1 + tranX/tranY));
            drawHeight = Math.abs((int) (screenHeight/tranY));

            startDrawY = (screenHeight -drawHeight)/2;
            endDrawY = (drawHeight + screenHeight)/2;
            drawWidth = Math.abs((int)(screenWidth/tranY));
            startDrawX = -drawWidth/2 + spritePixelX;
            endDrawX = drawWidth/2 + spritePixelX;
            boolean painted = false;
            int dWidth = endDrawX - startDrawX;
            for(int ix = startDrawX; ix < endDrawX;ix++){
                int texx = (int) (((ix-startDrawX)*1.0/dWidth*1.0)*spriteResX);
                if(tranY > 0 && ix > 0 && ix< screenWidth && tranY < depthBuffer[ix]){
                    g.drawImage(s.getDirectTexture(xPos,yPos),screenWidth-ix, startDrawY, screenWidth-ix +1,
                        endDrawY, spriteResX - texx, 0,  spriteResX - texx - 1, spriteResY, null);
                        painted = true;
                }
                if(Math.abs(ix-(screenWidth/2)) < 3){
                    this.hitID = s.getID();
                }
            }
            if(painted){
                g.setColor(Color.GREEN);
                g.drawString(s.getName(),screenWidth-((startDrawX+endDrawX)/2),startDrawY+40);
            }
            if(startDrawX<(screenWidth/2) && (screenWidth/2)<endDrawX && startDrawY<(screenWidth/2) && (screenWidth/2)<endDrawY) {
            	lastsprite = s;
            }
            
            

        }
    }

    private void drawSky(Graphics g){
        int x, texX;
        double camX, rayAngle;
        for (int dx = 0; dx < screenWidth / stepSize; dx++) {
            x = dx * stepSize;
            camX = (2.0 * x / screenWidth) - 1;
            rayAngle = (rot + (camX * 0.583));
            texX = (int) ((rayAngle / 6.283) * 1000);
            while(texX < 0){
                texX += 1000;
            }// doch im prinzip modulo
            while(texX >= 1000){
                texX -= 1000;
            }
            g.drawImage(texManager.getSkyTexture(0), x - stepSize - 1, 0, x + stepSize, screenHeight, texX, 100,
                texX + 1, 250, null);
        }
        //g.setColor(new Color(90, 90, 90));
        //g.fillRect(0, screenHeight / 2, (int) game.gibWidth(), ((int) game.gibHeight()) / 2);
    }

    private void floorCasting(Graphics g,Karte k){
        BufferedImage floorImage = new BufferedImage(screenWidth/floorRes, screenHeight/(2*floorRes),BufferedImage.TYPE_INT_RGB);
        // int[] rgbRaster = ((DataBufferInt) floorImage.getRaster().getDataBuffer()).getData();

        int SWFL = screenWidth/floorRes;
        int SHFL = screenHeight/(2*floorRes);
        double posZ = 0.5 * screenHeight;//Camera position
        double rayDirX0 = dirX - planeX;
        double rayDirY0 = dirY - planeY;
        double rayDirX1 = dirX + planeX;
        double rayDirY1 = dirY + planeY;
        double floorStepXpart = (rayDirX1 - rayDirX0) / (SWFL);
        double floorStepYpart = (rayDirY1 - rayDirY0) / (SWFL);
        int y, p, tx, ty;
        double rowDistance, floorStepX, floorStepY, floorX, floorY;
        for (int iy = SHFL; iy < screenHeight / (floorRes); iy++) {
            y = iy * floorRes;
            p = y - screenHeight / 2;
            rowDistance = posZ / p;//Abstand des Bodens zur Camera
            floorStepX = rowDistance * floorStepXpart;
            floorStepY = rowDistance * floorStepYpart;
            floorX = xPos + (rowDistance * rayDirX0);
            floorY = yPos + (rowDistance * rayDirY0);
            for (int ix = 0; ix < SWFL; ix++) {
                tx = (int) (texRes * (floorX % 1)) & (texRes - 1);
                ty = (int) (texRes * (floorY % 1)) & (texRes - 1);
                floorX += floorStepX;
                floorY += floorStepY;

                //    int xTex = (screenWidth / floorRes) - ix - 1;
                //     int yTex = iy - screenHeight / (2 * floorRes);
                //   int index = (xTex * (screenHeight/(2*floorRes))) + yTex;
                int shadowX = (int) Math.round((float)(floorX + 0.3));
                int shadowY = (int) (floorY);
                int texRGB;

                if (shadowX >= k.getSizeX() - 1 || shadowY < 0 || shadowX >= k.getSizeY() - 1 || shadowY < 0) {
                    texRGB =   this.floorTextureDark[tx + ty*texRes];
                } else if(k.getCoordinate(shadowX,shadowY)>0){
                    texRGB =   this.floorTextureDark[tx + ty*texRes];

                } else {
                    texRGB =   this.floorTexture[tx + ty*texRes];
                }

                floorImage.setRGB((SWFL) - ix - 1, iy - SHFL,texRGB);
                //  rgbRaster[index] = floorTexture.getRGB(tx,ty);

            }
        }
        g.drawImage(floorImage, 0, screenHeight / 2, screenWidth, screenHeight, 0, 0, SWFL,
            SHFL, null);
    }

    private void loadFloorTexture(){
        for(int x = 0; x < texRes;x++){
            for(int y = 0; y < texRes; y++){
                floorTexture[x + (y*texRes)] = texManager.getTexture(10).getRGB(x,y);
                floorTextureDark[x + (y*texRes)] = texManager.getDarkTexture(10).getRGB(x,y);
            }
        }
    }
    
    public void updategame(){
        game = con.getGame();
        screenWidth = game.gibWidth();
        screenHeight = game.gibHeight();
        run = true;
        Sprite test = new Sprite(15,15,"Barrel",0,0,true,texManager.getSpriteTexture(16),texManager.getSpriteTexture(15),texManager.getSpriteTexture(14),texManager.getSpriteTexture(13),texManager.getSpriteTexture(12),texManager.getSpriteTexture(11),texManager.getSpriteTexture(10),texManager.getSpriteTexture(9));
        sprites.add(test);
        Sprite directional = new Sprite(14,11,"Player",0,0,true,texManager.getSpriteTexture(8),texManager.getSpriteTexture(7),texManager.getSpriteTexture(6),texManager.getSpriteTexture(5),texManager.getSpriteTexture(4),texManager.getSpriteTexture(3),texManager.getSpriteTexture(2),texManager.getSpriteTexture(1));
        sprites.add(directional);

        depthBuffer = new double[screenWidth ];
        loadFloorTexture();
    }

    public void setwallRes(int r) {
        stepSize = r;
    }

    public void setfloorRes(int r) {
        floorRes = r;
    }

    public void setRun(boolean r){
        run = r;
    }

    public int getResolution() {
        return stepSize;
    }

    public int getHitID(){
        return this.hitID;
    }
    
    private void abbau(Connection ver) {
        try {
            ver.close();
        } catch (SQLException e) {
            System.err.println("Fehler beim schließen der Verbindung:" + e);
            System.exit(0);
        }
    }
    
    private Connection aufbau(Connection ver) {
        try {
            ver = DriverManager.getConnection("jdbc:mysql://srvxampp/q11wolfenstein", "q11wolfenstein", "abitur");
            return ver;
        } catch (Exception e) {
            System.err.println("Datenbankfehler(Verbindungsaufbau): " + e);
            System.exit(0);
            return null;
        }
    }

	
	public Sprite getLastsprite() {
		return lastsprite;
	}

	
	public void setLastsprite(Sprite lastsprite) {
		this.lastsprite = lastsprite;
	}
}

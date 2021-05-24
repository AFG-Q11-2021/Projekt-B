import java.awt.*;
//Author Julius

public interface Game {
    abstract int getWidth();

    abstract int getHeight();

    abstract void render();

    abstract void setSpieler(Spieler spiler);

    abstract Graphics getGraphics();
}

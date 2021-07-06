import java.awt.*;
//Author Julius

public interface Game {
    abstract int gibWidth();

    abstract int gibHeight();

    abstract void render();

    abstract void update();

    abstract void setSpieler(Spieler spiler);

    abstract Graphics getGraphics();
    
}

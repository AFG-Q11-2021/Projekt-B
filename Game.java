import java.awt.*;
//Author Julius

public interface Game {
    abstract double gibWidth();

    abstract double gibHeight();

    abstract void render();

    abstract void update();

    abstract void setSpieler(Spieler spiler);

    abstract Graphics getGraphics();
}

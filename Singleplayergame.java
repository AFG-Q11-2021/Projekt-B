/**
 * @author Christopher Scherübl, Laurens Birkenbach, Julius Rommel (07.05.2021 n.Chr);
 * @version 0.1
 */
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;

public class Singleplayergame extends Canvas implements KeyListener, Game
{
    public JFrame frame1;
    public Graphics graphics;
    private String title = "Game";
    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;

    private Spieler s;

    private Karte kartetest;//für den Darsteller umschreiben
    private Graphics g;
    private BufferStrategy bs;
    private int csizeX;
    private int csizeY;

    private boolean fwd=false;
    private boolean back=false;
    private boolean left=false;
    private boolean right=false;

    public Singleplayergame()
    {
        JFrame frame1 = new JFrame();
        Dimension size = new Dimension(WIDTH,HEIGHT);

        this.setPreferredSize(size);
        frame1.setTitle(title);
        frame1.add(this);
        frame1.pack();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);

        kartetest = new Karte();
        kartetest.setKartenArray(2, 2, 1);
        csizeX = (int)WIDTH/kartetest.getSizeX();
        csizeY = (int)HEIGHT/kartetest.getSizeY();

        this.createBufferStrategy(2);
        bs = this.getBufferStrategy();
        g = bs.getDrawGraphics();

        this.addKeyListener(this);
    }

    public void render()
    {
        g.setColor(new Color(0,0,0));
        g.drawRect(0, 0, WIDTH, HEIGHT);
        if(fwd==true){
            s.geradeGehen();
            System.out.println("geradeaufruf");
        }
        if(back==true){
            s.rueckwaertsGehen();
            System.out.println("zurückaufruf");
        }
        if(left==true){
            s.linksdrehen();
            System.out.println("linksaufruf");
        }
        if(right==true){
            s.rechtsdrehen();
            System.out.println("rechtsaufruf");
        }

        //Karte malen
        CastTest.paintMap(g,kartetest,s);
        paintMap();

        //Spieler malen
        paintPlayer();

        this.graphics = g;
        bs.show();
    }

    public void paintMap(){
        g.setColor(Color.BLACK);
        for(int x=0;x<kartetest.getSizeX();x++){
            for(int y=0;y<kartetest.getSizeY();y++){
                if(kartetest.getCoordinate(x, y)!=0){
                    g.fillRect(x*csizeX,y*csizeY,csizeX,csizeY);
                }
                else{
                    g.drawRect(x*csizeX,y*csizeY,csizeX,csizeY);
                }
            }
        }
    }

    public void paintPlayer(){
        int xc = (int)(s.getX()*csizeX);
        int yc = (int)(s.getY()*csizeY);
        g.setColor(Color.RED);
        g.fillOval(xc,yc, 10, 10);
        switch((int)s.getRotation()/90){
            case 1: g.drawLine(xc+5, yc+5, xc+5, yc-10);

            case 0: g.drawLine(xc+5, yc+5, xc+10, yc+5);

            case 2: g.drawLine(xc+5, yc+5, xc-10, yc+5);

            case 3: g.drawLine(xc+5, yc+5, xc+5, yc+10);

        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){ 
            //vorwärts
            fwd = true;
            System.out.println("geradep");
        }
        if(e.getKeyCode() == KeyEvent.VK_S){ 
            //rückwärts
            back = true;
            System.out.println("zurückp");
        }
        if(e.getKeyCode() == KeyEvent.VK_A){ 
            //links
            left = true;
            System.out.println("linksp");
        }
        if(e.getKeyCode() == KeyEvent.VK_D){ 
            //rechts
            right = true;
            System.out.println("rechtsp");
        }
    }

    public void keyReleased(KeyEvent e) {
        //vorwärts
        if(e.getKeyCode() == KeyEvent.VK_W){ 
            fwd = false;
            System.out.println("gerader");
        }
        //rückwärts
        if(e.getKeyCode() == KeyEvent.VK_S){ 
            back = false;
            System.out.println("zurückr");
        }
        //links
        if(e.getKeyCode() == KeyEvent.VK_A){ 
            left = false;
            System.out.println("linksr");
        }
        //rechts
        if(e.getKeyCode() == KeyEvent.VK_D){ 
            right = false;
            System.out.println("rechtsr");
        }
    }

    public int getWidth(){
        return WIDTH;
    }

    public int getHeight(){
        return HEIGHT;
    }
    
    public Graphics getGraphics(){
        return this.graphics;
    }

    public void setSpieler(Spieler spiler){
        s=spiler;
    }

}

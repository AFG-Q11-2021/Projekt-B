import java.awt.*;
import java.awt.event.ActionListener;

public class Frame
{
    public class frame extends JFrame implements ActionListener
    {
        private JButton schliessen;
        private JButton info;
        private JButton ende;
    }
    
    public static void main(String[] args)
    {
        frame frame = new frame("Menü");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
    
    public Fenster(String title)
    {
        
    }
}

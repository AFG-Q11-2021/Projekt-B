import java.awt.event.*;
import javax.swing.*;

//Author: Julius Rommel

@SuppressWarnings("serial")
public class Settings extends JFrame implements ActionListener {
    private Framee fra;
    private JTextField textspeed;
    private JLabel labelspeed;
    private JButton exit;
    private JButton save;

    public Settings(Framee f, double speed) {
        fra = f;

        save = new JButton("Save Settings");
        save.setBounds(280, 710, 750, 50);
        save.addActionListener(this);
        add(save);

        exit = new JButton("Back to Main Menu");
        exit.setBounds(280, 770, 750, 50);
        exit.addActionListener(this);
        add(exit);

        int temp = (int)(speed*100);
        textspeed = new JTextField(Integer.toString(temp));
        textspeed.setBounds(280, 590, 750, 50);
        add(textspeed);

        labelspeed = new JLabel("Spieler Speed");
        labelspeed.setBounds(180, 590, 750, 50);
        add(labelspeed);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1290, 1100);
        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            fra.returne();
            setVisible(false);
        }else if(e.getSource() == save) {
            double s = Integer.valueOf(textspeed.getText());
            s = s/100;
            fra.setSpeed(s);
        }
    }

}

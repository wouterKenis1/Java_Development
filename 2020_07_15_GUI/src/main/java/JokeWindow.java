import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JokeWindow extends JFrame{
    public static int JOKECOUNT = 0;
    {JOKECOUNT++;}

    private JButton bt;

    public JokeWindow(ActionListener parent){
        setSize(1024,768);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container window = this.getContentPane();
        window.setLayout(new GridLayout(3,10));
        bt = new JButton("Lol");
        bt.addActionListener(parent);
        add(bt);
        setTitle("First test of GUI - Title");
    }



}

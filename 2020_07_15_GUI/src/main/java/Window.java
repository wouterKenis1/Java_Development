import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class Window extends JFrame implements KeyListener {
    public Vector<JLabel> m_Labels = new Vector<JLabel>();
    private JButton bt = new JButton("noText");

    public void createGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = this.getContentPane();
        window.setLayout(new GridLayout(3,10));
        add(bt);
        bt.addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyChar() );
        bt.setText("Key Typed: " + e.getKeyChar() );

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed: " + e.getKeyChar() );
        bt.setText("Key Pressed: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released: " + e.getKeyChar() );
        bt.setText("Key Released: " + e.getKeyChar() );
    }
}

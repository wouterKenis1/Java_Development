package front;

import utils.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Window extends JFrame implements KeyListener {
    JFrame frame;
    int width = 300;
    int height = 300;

    Camera m_Camera = new Camera();
    ArrayList<GameObject> m_Objects = new ArrayList<>();

    public Window(){

        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JPanel panel = new JPanel();
        //add(panel);


        setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
//        Line2D line = new Line2D.Float(100,100,250,260);
//        graphics2D.draw(line);

//        graphics2D.translate(100,0);

        if(m_Camera != null){
            m_Camera.draw(graphics2D,m_Objects);
        }
        else {
            for (GameObject object : m_Objects) {
                object.draw(graphics2D);
            }
        }
    }

    public void drawLine(){
        Graphics2D graphics2D = (Graphics2D) getGraphics();
        graphics2D.drawLine(10,10,100,10);
    }

    public void add(GameObject object){
        m_Objects.add(object);
        object.setWindow(this);
    }

    public void update(float elapsedSec){
        for(GameObject object : m_Objects) {
           object.update(elapsedSec);
        }
        if(m_Camera != null) {
            m_Camera.update(elapsedSec);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        m_Camera.processKeyEvent(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        m_Camera.processKeyEvent(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        m_Camera.processKeyEvent(e);
    }
}

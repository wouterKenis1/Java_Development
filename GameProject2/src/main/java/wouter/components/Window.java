package wouter.components;

import org.springframework.stereotype.Component;
import wouter.components.gameobjects.Rectangle;
import wouter.components.utis.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Component
public class Window extends JFrame {
    ArrayList<GameObject> m_Objects = new ArrayList<>();

    public Window(){

        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        this.repaint();
        for(GameObject object : m_Objects){
            object.draw((Graphics2D)g);
        }

    }

    public void add(GameObject object) {
        m_Objects.add(object);
    }

    public void update(float elapsedSec) {
        for(GameObject object : m_Objects) {
            object.update(elapsedSec);
        }
    }
}

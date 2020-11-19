package front;


import com.melloware.jintellitype.IntellitypeListener;
import utils.GameObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;



public class Camera{
    Point m_Pos = new Point(0,0);



    public void draw(Graphics2D graphics2D, List<GameObject> objects){
        graphics2D.translate(m_Pos.x,m_Pos.y);
        for(GameObject object : objects){
            object.draw(graphics2D);
        }
    }

    public void processKeyEvent(KeyEvent e){
        System.out.println("processing key");
        switch(e.getID()){
            case KeyEvent.VK_DOWN:
                m_Pos.y += 10;
                break;
            case KeyEvent.VK_UP:
                m_Pos.y -= 10;
                break;
            case KeyEvent.VK_LEFT:
                m_Pos.x -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                m_Pos.x += 10;
                break;
            default:
                System.out.println("default key");
        }
    }

    public void update(float elapsedSec){

    }
}

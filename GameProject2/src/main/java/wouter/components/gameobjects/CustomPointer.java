package wouter.components.gameobjects;

import org.springframework.stereotype.Component;

import java.awt.*;

@Component("customPointer")
public class CustomPointer extends Square {

    public CustomPointer(){m_Width = 20;}
    public CustomPointer(int width){
        m_Width = width;
    }

    @Override
    public void update(float elapsedSec) {
        Point point = MouseInfo.getPointerInfo().getLocation();
        //System.out.println(point.x + ", " + point.y);
        if(m_Window != null){
            Graphics g = m_Window.getGraphics();
            m_PosX = point.x;
            m_PosY = point.y;
//            g.translate(m_PosX,m_PosY);
//            m_Window.update(g);
        } else {
            m_PosX = point.x;
            m_PosY = point.y;
        }
        //System.out.println(m_PosX + ", " + m_PosY);
    }

    public void draw(){
        Graphics2D g = (Graphics2D) m_Window.getGraphics();
        g.drawRect(m_PosX, m_PosY, m_Width, m_Width);
    }

}

package wouter.components.gameobjects;

import org.springframework.stereotype.Component;
import wouter.components.utis.GameObject;

import java.awt.*;

@Component("rectangle")
public class Rectangle extends GameObject {
    int m_PosX = 50;
    int m_PosY = 50;
    int m_Width = 25;

    public Rectangle(){}

    public Rectangle(int x, int y,int width){
        m_PosX = x;
        m_PosY = y;
        m_Width = width;
    }

    @Override
    public void update(float elapsedSec) {

    }

    @Override
    public void draw(Graphics2D g) {
        g.drawRect(m_PosX, m_PosY, m_Width, m_Width);

    }
}

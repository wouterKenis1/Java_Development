package wouter.components.gameobjects;

import org.springframework.stereotype.Component;

import java.awt.*;

@Component("square")
public class Square extends Rectangle {
    int m_PosX = 50;
    int m_PosY = 50;
    int m_Width = 25;

    public Square(){}

    public Square(int x, int y, int width){
        m_PosX = x;
        m_PosY = y;
        m_Width = width;
    }

    @Override
    public void update(float elapsedSec) {

    }

    @Override
    public void draw(Graphics2D g) {
        g.drawRect(m_PosX - m_Width/2, m_PosY- m_Width/2, m_Width, m_Width);

    }
}

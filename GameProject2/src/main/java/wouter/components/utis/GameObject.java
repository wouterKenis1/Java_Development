package wouter.components.utis;

import java.awt.*;

public abstract class GameObject {
    public Window m_Window;
    public GameObject m_Parent;

    public abstract void update(float elapsedSec);
    public abstract void draw(Graphics2D g);

    public Window getWindow() {
        return m_Window;
    }

    public void setWindow(Window window) {
        m_Window = window;
    }

    public GameObject getM_Parent() {
        return m_Parent;
    }

    public void setParent(GameObject parent) {
        m_Parent = parent;
    }
}

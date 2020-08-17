import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Player {
    enum Direction{
        Up,
        Down,
        Left,
        Right
    }

    int m_PosX, m_PosY;
    Sprite m_Sprite;
    double m_TimeSinceLastUpdate = 0;
    double m_RefreshRate = 0;

    Player(Image img){
        m_Sprite = new Sprite(img);
        setInputs();
    }
    Player(Image spriteSheet, int rows, int cols, Sprite.CycleMode mode){
        m_Sprite = new Sprite(spriteSheet,rows,cols,mode);
        setInputs();
    }
    Player(Sprite sprite){
        m_Sprite = sprite;
        setInputs();
    }

    private void setInputs(){
        InputHandler handler = Main.getInputHandler();
        KeyEventHandler keyHandler = (KeyEventHandler) (handler.keyEventHandler);
        keyHandler.addInput(KeyCode.UP, () -> moveDir(Direction.Up));
        keyHandler.addInput(KeyCode.DOWN, () -> moveDir(Direction.Down));
        keyHandler.addInput(KeyCode.LEFT, () -> moveDir(Direction.Left));
        keyHandler.addInput(KeyCode.RIGHT, () -> moveDir(Direction.Right));
    }


    public void update(double elapsedSec){
        m_TimeSinceLastUpdate += elapsedSec;
        if(m_TimeSinceLastUpdate >= m_RefreshRate){
            m_TimeSinceLastUpdate = 0;
            // sync update
            m_Sprite.m_Sprite.setX(m_PosX);
            m_Sprite.m_Sprite.setY(m_PosY);
            //System.out.println("Pos: " + m_PosX + ',' + m_PosY);
        }
        // async update
        m_Sprite.update();


    }


    private void moveDir(Direction dir){
        switch(dir){
            case Up:
                move(0,-2);
                m_Sprite.setOffsetY(32);
                break;
            case Down:
                move(0,2);
                m_Sprite.setOffsetY(0);
                break;
            case Left:
                move(-2,0);
                m_Sprite.setOffsetY(64);
                break;
            case Right:
                move(2,0);
                m_Sprite.setOffsetY(96);
                break;

        }
    }

    private void move(int x, int y){
        //System.out.println(x + "," + y);
        m_PosX += x;
        m_PosY += y;
    }
}

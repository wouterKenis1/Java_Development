package wouter.gameobjects;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import wouter.MainApp;
import wouter.utils.inputs.InputHandler;
import wouter.utils.inputs.KeyEventHandler;

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

    public Player(Scene scene, Image spriteSheet, int rows, int cols, Sprite.CycleMode mode){
        m_Sprite = new Sprite(spriteSheet,rows,cols,mode);
//        boolean closedStage = false;
//        if(stage.getScene() == null){
//            closedStage = true;
//            stage.show();
//        }
        setInputs(scene);
//        if(closedStage){
//            stage.close();
//        }
    }


    private void setInputs(Scene scene){
        InputHandler handler = MainApp.getInputHandler();
        KeyEventHandler keyHandler = (KeyEventHandler) (handler.m_KeyEventHandler);
        keyHandler.addInput(scene, KeyCode.UP, () -> moveDir(Direction.Up));
        keyHandler.addInput(scene, KeyCode.DOWN, () -> moveDir(Direction.Down));
        keyHandler.addInput(scene, KeyCode.LEFT, () -> moveDir(Direction.Left));
        keyHandler.addInput(scene, KeyCode.RIGHT, () -> moveDir(Direction.Right));
    }

    public Sprite getSprite() {
        return m_Sprite;
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

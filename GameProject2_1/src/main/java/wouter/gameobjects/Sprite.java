package wouter.gameobjects;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.stereotype.Component;

//@Component
public class Sprite {
    public enum CycleMode{
        REPEATLINE, // 1,2,3,1,2,3
        NEXTLINE,   // 1,2,3,4,5,6,1,2,3,4,5,6
        BOUNCELINE,  // 1,2,3,2,1,2,3,2,1
        NOCYCLE     // 1,1,1,1
    }

    //sprite variables
    public Image m_SpriteSheet;
    public ImageView m_Sprite;
    public int m_Rows, m_Cols;
    public int m_SpriteWidth, m_SpriteHeight;
    public int m_OffsetX, m_OffsetY;

    int currFrame = 0;
    boolean moveRight = true;

    // mode
    CycleMode m_Mode;

    // frame variables
    public static int frameCounter = 0;
    static double timeSinceLastFrame = 0;
    static double frameDuration = 1.0 / 1.0; // time per frame

    // frame update
    static public void updateFrameCounter(double elapsedSec){
        timeSinceLastFrame += elapsedSec;
        if(timeSinceLastFrame >= frameDuration){
            timeSinceLastFrame -= frameDuration;
            frameCounter++;
        }
    }


    public Sprite(){
        this(new Image("Pokemon_Player.png"),4,3,CycleMode.BOUNCELINE);
    };
    public Sprite(Image spriteSheet){this(spriteSheet,1,1,0,0,CycleMode.NOCYCLE);}
    public Sprite(Image spriteSheet, int rows, int cols, CycleMode mode){
        this(spriteSheet,rows,cols,0,0,mode);
    }

    public Sprite(Image spriteSheet, int rows, int cols, int offsetX, int offsetY, CycleMode mode){
        m_SpriteSheet = spriteSheet;
        m_Mode = mode;
        m_Rows = rows;
        m_Cols = cols;
        m_OffsetX = offsetX;
        m_OffsetY = offsetY;
        initSprite();
        m_Sprite.setX(100);
        m_Sprite.setY(100);
        m_Sprite.setFitWidth(100);
        m_Sprite.setPreserveRatio(true);
    }


    private void initSprite(){
        m_SpriteWidth = (int)m_SpriteSheet.getWidth() / m_Cols;
        m_SpriteHeight = (int)m_SpriteSheet.getHeight() / m_Rows;
        m_Sprite = new ImageView(m_SpriteSheet);
        m_Sprite.setViewport(new Rectangle2D(m_OffsetX,m_OffsetY,m_SpriteWidth,m_SpriteHeight));

    }

    public void update(){
        switch(m_Mode){
            case REPEATLINE:
                update_Repeat();
                break;
            case NEXTLINE:
                update_Next();
                break;
            case BOUNCELINE:
                update_Bounce();
                break;
            case NOCYCLE:
                break;
        }
    }
    private void update_Repeat(){
        m_Sprite.setViewport(new Rectangle2D(m_SpriteWidth * (frameCounter % m_Cols),m_OffsetY, m_SpriteWidth, m_SpriteHeight ));
    }
    private void update_Next(){
        m_Sprite.setViewport(new Rectangle2D(m_SpriteWidth * (frameCounter % m_Cols),m_SpriteHeight * (frameCounter / m_Rows), m_SpriteWidth, m_SpriteHeight ));
    }
    private void update_Bounce(){

        int i = (int)frameCounter % ((m_Cols-1) * 2) ;

        if(i < m_Cols){
            m_Sprite.setViewport(new Rectangle2D(m_SpriteWidth * i,m_OffsetY, m_SpriteWidth, m_SpriteHeight ));
        }
        else{
            m_Sprite.setViewport(new Rectangle2D(m_SpriteWidth * (m_Cols*2 - i - 2),m_OffsetY, m_SpriteWidth, m_SpriteHeight ));
        }
        //System.out.println(m_Sprite.getViewport().getMinX() / m_SpriteWidth);
    }

    public void setOffsetX(int offset){
        m_OffsetX = offset;
    }
    public void setOffsetY(int offset){
        m_OffsetY = offset;
    }
}
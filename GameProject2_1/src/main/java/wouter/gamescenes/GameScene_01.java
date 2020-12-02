package wouter.gamescenes;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import wouter.gameobjects.Player;
import wouter.gameobjects.Sprite;
import wouter.utils.GameScene;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameScene_01 extends GameScene {

    public Player m_Player;

    public GameScene_01(){
        m_Title = "GameScene_01";
        m_Scene = new Scene(this,600,400);
        Image img = null;
        try {
            img = new Image(new FileInputStream("src/main/resources/Pokemon_Player.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        m_Player = new Player(getScene(), img,4,3, Sprite.CycleMode.BOUNCELINE);
        getChildren().add(m_Player.getSprite().m_Sprite);
    }

    public void update(double elapsedSec){
        //System.out.println("01");
        m_Player.update(elapsedSec);
    }

}

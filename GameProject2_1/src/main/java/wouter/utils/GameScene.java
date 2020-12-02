package wouter.utils;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import wouter.gamescenes.GameScene_01;

import java.util.ArrayList;
import java.util.List;

public class GameScene extends Group {
    public Scene m_Scene;
    List<GameObject> m_Objects = new ArrayList<>();
    public String m_Title;

    public GameScene(){
        //this(100,100);
    }
    public GameScene(double width, double height){
        m_Scene = new Scene(this,width,height);
        //m_Objects = new ArrayList<>();
    }

    public void update(double elapsedSec){

    }

    public String getTitle() {
        return m_Title;
    }
}

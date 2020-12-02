package wouter;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import wouter.gameobjects.Player;
import wouter.gameobjects.Sprite;
import wouter.gamescenes.GameScene_01;
import wouter.gamescenes.GameScene_02;
import wouter.utils.GameObject;
import wouter.utils.GameScene;
import wouter.utils.inputs.InputHandler;
import wouter.utils.inputs.KeyEventHandler;

import java.awt.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


public class MainApp extends Application {

    static InputHandler m_InputHandler;
    double m_PrevTime = 0;
    Player m_Player;

    public List<GameScene> m_Groups = new ArrayList<>();
    public int m_CurrentGroupIndex = 0;

    public MainApp(){

    }

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        m_InputHandler = new InputHandler(this);
        //m_InputHandler.setAppObject(this);

        stage.addEventHandler(MouseEvent.MOUSE_PRESSED, m_InputHandler.m_MouseEventEventHandler);
        stage.addEventFilter(KeyEvent.KEY_PRESSED,m_InputHandler.m_KeyEventHandler);




        // region timerSetup
        // timers
        m_PrevTime = System.nanoTime() / 1000000000.0;
        // make update possible
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {

                double currTime = l /1000000000.0;

                double elapsed = currTime - m_PrevTime;

                update(elapsed);
                m_PrevTime = currTime;
            }
        };
        timer.start();
        // endregion
        addGameScene(new GameScene_01());
        addGameScene(new GameScene_02());

        stage.setScene(m_Groups.get(0).getScene());
        //stage.setTitle(((GameScene)m_Groups.get(0)).getTitle());
        //stage.setTitle("NoName");
        stage.show();
    }

    public void update(double elapsedSec){
        int i = Sprite.frameCounter;
        Sprite.updateFrameCounter(elapsedSec);


        //System.out.println("Updating: " + m_CurrentGroupIndex);
        m_Groups.get(m_CurrentGroupIndex).update(elapsedSec);




    }

    public static InputHandler getInputHandler(){
        return m_InputHandler;
    }


    public void ChangeScene(){

        Group group = m_Groups.get(m_CurrentGroupIndex);
        Scene scene = group.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();

        m_CurrentGroupIndex++;
        if(m_CurrentGroupIndex == m_Groups.size()){
            m_CurrentGroupIndex = 0;
        }

        //m_RootGroup = m_Groups.get(m_CurrentGroupIndex);
        stage.setScene(m_Groups.get(m_CurrentGroupIndex).getScene());
        stage.setTitle(((GameScene)m_Groups.get(m_CurrentGroupIndex)).getTitle());

//        if(m_RootGroup instanceof GameScene_01){
//            m_RootGroup = new GameScene_02(stage);
//            m_Scene = m_RootGroup.getScene();
//            stage.setScene(m_Scene);
//        }
//        else if(m_RootGroup instanceof GameScene_02){
//            m_RootGroup = new GameScene_01(stage);
//            m_Scene = m_RootGroup.getScene();
//            stage.setScene(m_Scene);
//        }

        // error on switching scenes, but does not crash

        stage.show();

    }

    public void addGameScene(GameScene gameScene){
        m_Groups.add(gameScene);
        ((KeyEventHandler) m_InputHandler.m_KeyEventHandler).addInput(gameScene.getScene(), KeyCode.C,() -> ChangeScene());
    }

}

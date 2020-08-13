package navigation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.shape.TriangleMesh;
import javafx.stage.Stage;

public class Main extends Application {
    Group m_RootGroup = new Group();
    Scene m_Scene = new Scene(m_RootGroup,1920,1080);
    ObservableList<Node> m_GameObjects;

    double m_PrevTime = 0;
    double m_FrameDuration = 0;
    double m_FrameEnd = 1.0/60.0;



    public static void main(String[] args) {
        RandomVisual.Main mainObject = new RandomVisual.Main();
        mainObject.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        m_GameObjects =  m_RootGroup.getChildren();





        // timers
        m_PrevTime = System.nanoTime() / 1000000000.0;

        // make update possible
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                double currTime = l /1000000000.0;
                double elapsed = currTime - m_PrevTime;
                m_FrameDuration += elapsed;
                if(m_FrameDuration >= m_FrameEnd){
                    m_FrameDuration = 0;
                    update();
                }
                m_PrevTime = currTime;
            }
        };
        timer.start();

        stage.setTitle("--Title of Game--");
        stage.setScene(m_Scene);
        stage.show();
    }

    private void update(){

    }
}

package RandomVisual;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;


public class Main extends Application {

    Group m_RootGroup = new Group();
    Scene m_Scene = new Scene(m_RootGroup,1920,1080);
    ObservableList<Node> m_GameObjects;

    Text[] m_Labels = new Text[6];
    Rectangle[] m_Rectangles = new Rectangle[6];
    Text[] m_Results = new Text[6];
    int maxUpdates = 1000;
    int currentUpdate = 0;


    double m_PrevTime = 0;
    double m_FrameDuration = 0;
    double m_FrameEnd = 1.0/60.0;

    Random randomGen = new Random();

    public static void main(String[] args) {
        Main mainObject = new Main();
        mainObject.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        m_GameObjects =  m_RootGroup.getChildren();

        for(int i = 0; i < m_Labels.length; i++){
            m_Labels[i] = new Text((i+1) + ": ");
            m_Labels[i].setX(100);
            m_Labels[i].setY(100 + 50*i);
            m_RootGroup.getChildren().add(m_Labels[i]);
        }

        for(int i = 0; i < m_Rectangles.length; i++){
            m_Rectangles[i] = new Rectangle(100,125 + 50*i, 10, 20);
            m_Rectangles[i].setX(100);
            m_Rectangles[i].setY(105 + 50*i);
            m_RootGroup.getChildren().add(m_Rectangles[i]);
        }

        for(int i = 0; i < m_Results.length; i++){
            m_Results[i] = new Text("0");
            m_Results[i].setX(125);
            m_Results[i].setY(100 + 50*i);
            m_RootGroup.getChildren().add(m_Results[i]);
        }

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
        if(currentUpdate < maxUpdates) {
            int randomNumber = randomGen.nextInt(6); // [0-5]
            m_Rectangles[randomNumber].setWidth(m_Rectangles[randomNumber].getWidth() + 1); // add 1 to width
            //m_Results[randomNumber].setText(String.valueOf(m_Rectangles[randomNumber].getWidth()));
            int txtInt = (int) m_Rectangles[randomNumber].getWidth();
            m_Results[randomNumber].setText(String.valueOf(txtInt));

            currentUpdate++;
        }
    }

}

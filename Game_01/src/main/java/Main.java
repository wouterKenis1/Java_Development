import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class Main extends Application {

    Group m_RootGroup = new Group();
    Scene m_Scene = new Scene(m_RootGroup,1920/3,1080/3);
    ObservableList<Node> m_GameObjects;
    double m_PrevTime = 0;
    //Sprite m_Sprite;
    static InputHandler m_InputHandler ;
    Player m_Player;

    public Main(){
        m_InputHandler = new InputHandler(this);
    }
    public static void main(String[] args) {
        Main mainObject = new Main();
        mainObject.launch(args);
    }

    public static InputHandler getInputHandler(){
        return m_InputHandler;
    }

    @Override
    public void start(Stage stage) throws Exception{
        m_GameObjects =  m_RootGroup.getChildren();

        Image img = new Image("Pokemon_Player.png");
        //m_Sprite = new Sprite(img,3,3, 0,0,Sprite.CycleMode.BOUNCELINE); // down
        //m_RootGroup.getChildren().add(m_Sprite.m_Sprite);

        m_Player = new Player(img,4,3,Sprite.CycleMode.BOUNCELINE);
        m_RootGroup.getChildren().add(m_Player.m_Sprite.m_Sprite);

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


//        m_Sprite.m_Sprite.addEventFilter(MouseEvent.MOUSE_PRESSED, m_InputHandler.mouseEventHandler);
//        m_Sprite.m_Sprite.addEventFilter(KeyEvent.KEY_TYPED,m_InputHandler.keyEventHandler);
        stage.addEventHandler(MouseEvent.MOUSE_PRESSED, m_InputHandler.mouseEventHandler);
        stage.addEventFilter(KeyEvent.KEY_PRESSED,m_InputHandler.keyEventHandler);

        stage.setTitle("--Title of Game--");
        stage.setScene(m_Scene);
        stage.show();
    }

    private void update(double elapsedSec){
        int i = Sprite.frameCounter;
        Sprite.updateFrameCounter(elapsedSec);
        if(Sprite.frameCounter != i) {
            //System.out.println(Sprite.frameCounter);
        }
        //m_Sprite.update();
        m_Player.update(elapsedSec);
    }





}

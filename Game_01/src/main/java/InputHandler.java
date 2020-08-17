import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;


public class InputHandler  {
    private final Main mainObject;
    public EventHandler<MouseEvent> mouseEventHandler;
    public EventHandler<KeyEvent> keyEventHandler;

    public InputHandler(Main main){
        mainObject = main;
        mouseEventHandler = new MouseEventHandler(mainObject);
        keyEventHandler = new KeyEventHandler(mainObject);
    }




}


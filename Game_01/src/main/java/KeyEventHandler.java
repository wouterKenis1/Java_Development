import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Pair;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class KeyEventHandler implements EventHandler<KeyEvent> {

    private final Main mainObject;

    //Runnable codeFunc;

    Vector<Pair<KeyCode,Runnable>> inputFunctions;


    public KeyEventHandler(Main main) {
        mainObject = main;
        inputFunctions = new Vector<Pair<KeyCode, Runnable>>();
        addInput(KeyCode.UP,this::moveUp);
        addInput(KeyCode.RIGHT,this::moveRight);
}
    public void addInput(KeyCode code, Runnable function){
        inputFunctions.add(new Pair<KeyCode,Runnable>(code,function));
    }

    public void removeInput(KeyCode code, Runnable function){
        inputFunctions.remove(new Pair<KeyCode,Runnable>(code,function));
    }


    @Override
    public void handle(KeyEvent keyEvent) {
        //System.out.println(keyEvent.getCharacter());
        System.out.println(keyEvent.getCode());
        KeyCode code = keyEvent.getCode();
        for(Pair<KeyCode,Runnable> pair : inputFunctions){
            if(pair.getKey() == code){
                pair.getValue().run();
            }
        }
    }

    private void moveUp(){
        //System.out.println("move up");
        //mainObject.m_Sprite.m_Sprite.setY(mainObject.m_Sprite.m_Sprite.getY() - 2); // move sprite 2 up
    }
    private void moveRight(){
        //System.out.println("move right");
        //mainObject.m_Sprite.m_Sprite.setX(mainObject.m_Sprite.m_Sprite.getX() + 2); // move sprite 2 right
    }

}

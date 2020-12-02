package wouter.utils.inputs;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseEventHandler implements EventHandler<MouseEvent> {

    public MouseEventHandler() {

    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.isPrimaryButtonDown()){
            System.out.println("mouse: left clicked");
        }
        if(mouseEvent.isSecondaryButtonDown()){
            System.out.println("mouse: right clicked");
        }
        System.out.println("screen: " + mouseEvent.getScreenX() + "," + mouseEvent.getScreenY());
        System.out.println("scene: " + mouseEvent.getSceneX() + "," + mouseEvent.getSceneY());
    }
}

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseEventHandler implements EventHandler<MouseEvent> {
    private final Main mainObject;

    public MouseEventHandler(Main main) {
        mainObject = main;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.isPrimaryButtonDown()){
            System.out.println("mouse: left clicked");
        }
        if(mouseEvent.isSecondaryButtonDown()){
            System.out.println("mouse: right clicked");
        }
    }
}

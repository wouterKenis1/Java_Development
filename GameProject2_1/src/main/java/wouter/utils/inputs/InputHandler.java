package wouter.utils.inputs;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import wouter.MainApp;


//public class InputHandler implements ApplicationContextAware {
public class InputHandler{
    public EventHandler<MouseEvent> m_MouseEventEventHandler;
    public EventHandler<KeyEvent> m_KeyEventHandler;

    AnnotationConfigApplicationContext context;

    public InputHandler(MainApp app) {
        //m_KeyEventHandler = context.getBean(KeyEventHandler.class);
        m_KeyEventHandler = new KeyEventHandler(app);
        m_MouseEventEventHandler = new MouseEventHandler();
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        context = (AnnotationConfigApplicationContext) applicationContext;
//    }


}

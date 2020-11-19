package wouter.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import wouter.components.Window;
import wouter.components.gameobjects.CustomPointer;
import wouter.components.gameobjects.Rectangle;
import wouter.components.gameobjects.Square;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(Config.class);

        Window window = ctx.getBean("window", Window.class);
        Rectangle rect1 = ctx.getBean("rectangle", Rectangle.class);
        window.add(rect1);
        CustomPointer pointer = ctx.getBean("customPointer",CustomPointer.class);
        window.add(pointer);

        // triggering achievement
        ctx.getBean("square", Square.class);
        ctx.getBean("square", Square.class);
        ctx.getBean("square", Square.class);
        ctx.getBean("square", Square.class);
        ctx.getBean("square", Square.class);


        long t1 = System.currentTimeMillis();
        while (true) {
            try {
                long t2 = System.currentTimeMillis();
                window.update((t2 - t1) / 1000);
                window.paint(window.getGraphics());
                t1 = t2;


                //Thread.sleep(1000);

//            } catch (InterruptedException e) {
//                e.printStackTrace();
            } finally {

            }
        }
    }
}

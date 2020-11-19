package wouter;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import wouter.Config;
import wouter.back.CustomPointer;
import wouter.back.Square;
import wouter.front.Window;


public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(Config.class);
        // region game1
//        Window window = new Window();
//
//        Square square1 = new Square();
//        window.add(square1);
//
//        Square square2 = new Square(113,113,27);
//        window.add(square2);
//
//        CustomPointer pointer = new CustomPointer(35);
//        window.add(pointer);
//
//        long t1 = System.currentTimeMillis();
//
//        while(true){
//            try {
//                long t2 = System.currentTimeMillis();
//                window.update((t2 - t1) / 1000);
//                window.paint(window.getGraphics());
//                t1 = t2;
//
//
//                //Thread.sleep(1000);
//
////            } catch (InterruptedException e) {
////                e.printStackTrace();
//            } finally {
//
//            }
//        }
        // endregion

        // region game2
//        Square square1 = ctx.getBean("square",Square.class);
//        Window window = ctx.getBean("window",Window.class);
//
//        window.add(square1);
//        Square square2 = ctx.getBean("square",Square.class);
//        window.add(square2);
//
//        CustomPointer pointer = ctx.getBean("customPointer",CustomPointer.class);
//        window.add(pointer);
        // endregion

    }
}

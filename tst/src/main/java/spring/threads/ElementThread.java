package spring.threads;

import spring.model.Element;

public class ElementThread implements Runnable{
    Thread thread;
    Element element;

    public ElementThread(Element element){
        this.element = element;
    }

    @Override
    public void run() {
        try {
            for(int x = 0; x < 20; x++){
                System.out.println(element.getName() + ": " + x);
                Thread.sleep(200);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        thread = new Thread(this, element.getName());
        thread.start();
    }

}

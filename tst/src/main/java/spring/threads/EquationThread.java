package spring.threads;

import spring.model.Element;
import spring.model.Equation;
import spring.repository.ElementRepo;
import spring.repository.EquationRepo;

public class EquationThread implements Runnable{
    Thread thread;
    Equation equation;

    public EquationThread(Equation equation){
        this.equation = equation;
    }

    @Override
    public void run() {
        try {
            for(int x = 0; x < 20; x++){
                System.out.println("thread with child <" + equation.getChild() +">: " + x);
                Thread.sleep(200);
            }
            if(equation.getVoteCount() < 5){
                if(equation.isNewElement()){
                    new ElementRepo().deleteElement(equation.getChild());
                }
                new EquationRepo().deleteEquation(equation);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        thread = new Thread(this);
        thread.start();
    }

}

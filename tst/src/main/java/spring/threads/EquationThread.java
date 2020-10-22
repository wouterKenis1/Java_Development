package spring.threads;

import spring.model.Element;
import spring.model.Equation;
import spring.repository.ElementRepo;
import spring.repository.EquationRepo;

public class EquationThread implements Runnable{
    Thread thread;
    Equation equation;
    Element child;

    public EquationThread(Equation equation){
        this.equation = equation;
    }

    @Override
    public void run() {
        try {
            for(int x = 0; x < 10; x++){
                System.out.println("thread with equation <" + equation.toString() +">: " + x);
                Thread.sleep(2000);
            }
            // find the equation again to avoid dirty data
            equation = new EquationRepo().findEquationByParentNames(equation.getParent1().getName(),equation.getParent2().getName());
            // hardcoded 1 vote needed to persist.
            // change this if condition with the preferred algorithm
            if(equation.getVoteCount() == 0){
                if(equation.isNewElement()){
                    System.out.println("get child element");
                    child = equation.getChild();
                }
                System.out.println("delete equation");
                new EquationRepo().deleteEquation(equation);
                System.out.println("delete child element if newElement");
                if(child != null){
                    new ElementRepo().deleteElement(child);
                }
            }
            else{
                equation.setPublic(true);
                new EquationRepo().updateEquitionPublic(equation);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        System.out.println("Thread made with equation: " + equation);

        thread = new Thread(this);
        thread.start();

    }

}

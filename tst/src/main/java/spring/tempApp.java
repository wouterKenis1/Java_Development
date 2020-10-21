package spring;

import spring.model.Element;
import spring.model.Equation;
import spring.repository.ElementRepo;
import spring.repository.EquationRepo;

import java.util.List;

public class tempApp {
// does not work properly --> manually reset the database from workbench
    public static void main(String[] args) {
        ElementRepo elementRepo = new ElementRepo();
        EquationRepo equationRepo = new EquationRepo();
        List<Element> elements = elementRepo.getAllElements();
        for(Element e : elements){
            if(e.getId() > 4){
                elementRepo.deleteElement(e);
            }
        }

        List<Equation> equations = equationRepo.getAllEquations();
        for(Equation e : equations){
            equationRepo.deleteEquation(e);
        }
    }
}

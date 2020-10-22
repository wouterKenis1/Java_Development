package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.model.*;
import spring.repository.ElementRepo;
import spring.repository.EquationRepo;
import spring.threads.EquationThread;
import spring.wrappers.ElementPair;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomePageController {
    ElementRepo elementRepo = new ElementRepo();
    EquationRepo equationRepo = new EquationRepo();
    ElementPair elementPair = null;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView handleHomepageGet(ModelMap model) {
        System.out.println("Home GET Success!");
        model.addAttribute("databaseElements",elementRepo.getStartElements());
        return new ModelAndView("homepage",model);
    }

    @RequestMapping(value="/home", method = RequestMethod.POST)
    public ModelAndView handleHomepagePost(@ModelAttribute ElementPair elements, ModelMap model){
        System.out.println("Home POST Success!");
        elementPair = elements;
        List<Element> arrList = new ArrayList<>();
        Element combinationElement = elementRepo.findPublicCombinationElementByName(elements.name1, elements.name2);
        if(combinationElement != null) {
            arrList.add(combinationElement);
            model.addAttribute("boolElementAdded",true);
        }
        else{
            model.addAttribute("name1",elements.name1);
            model.addAttribute("name2",elements.name2);
            model.addAttribute("boolElementAdded",false);
            return handleCreateElementGet(model);
        }
        model.addAttribute("elementsFromJava",arrList);
        return new ModelAndView("homepage",model);

    }


    @RequestMapping(value="/createElement",method = RequestMethod.GET)
    public ModelAndView handleCreateElementGet(ModelMap model){
        System.out.println("Create GET Success!");
        String name1 = (String)model.getAttribute("name1");
        String name2 = (String)model.getAttribute("name2");

        List<Equation> equationList = equationRepo.findEquationsByParentNames(name1, name2);
        model.addAttribute("possibleCombinations",equationList);

        return new ModelAndView("createElement",model);
    }

    @RequestMapping(value="/createElement",method = RequestMethod.POST)
    public ModelAndView handleCreateElementPost(@ModelAttribute String newElementName, ModelMap model) {
        // sout for debugging purposes
        System.out.println("CREATE POST Success!");
        Equation combinationEquation = equationRepo.findEquation(
                elementPair.element1.getName(),
                elementPair.element2.getName(),
                newElementName);
        if (combinationEquation == null){
            // make the equation, but don't set the child
            Equation newEquation = new Equation(true);
            newEquation.setParent1(elementPair.element1);
            newEquation.setParent2(elementPair.element2);

            // make a new child element if necessary
            if (elementRepo.findElementByName(newElementName) == null) {
                Element newElement = new Element(newElementName);
                elementRepo.saveElement(newElement);
                List<Element> elementList = new ArrayList<>();
                elementList.add(newElement);
                model.addAttribute("ElementsFromJava", elementList);
                model.addAttribute("boolElementAdded", true);
                newEquation.setNewElement(true);

            } else {
                model.addAttribute("boolElementAdded", false);
            }
            // fill the child of the equation
            newEquation.setChild(elementRepo.findElementByName(newElementName));
            equationRepo.saveEquation(newEquation);
//        EquationThread equationThread = new EquationThread(newEquation);
//        equationThread.start();

            model.addAttribute("databaseElements", elementRepo.findElementByName(newElementName));
            return handleHomepageGet( model);
        } else {
            combinationEquation.addVote();
            equationRepo.updateEquationVotes(combinationEquation);
            System.out.println("vote added");
            return handleHomepageGet( model);
        }
    }

}

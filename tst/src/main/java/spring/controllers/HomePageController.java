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
        Element combinationElement = elementRepo.findCombinationElementByName(elements.name1, elements.name2);
        if(combinationElement != null) {
            arrList.add(combinationElement);
            model.addAttribute("boolElementAdded",true);
        }
        else{
            model.addAttribute("name1",elements.name1);
            model.addAttribute("name2",elements.name2);
            model.addAttribute("boolElementAdded",false);
            return new ModelAndView("createElement",model);
        }
        model.addAttribute("elementsFromJava",arrList);
        return new ModelAndView("homepage",model);
    }
//    @RequestMapping(value="/createElement",method = RequestMethod.POST)
//    public ModelAndView handleCreateElementPost(@ModelAttribute String newElementName, ModelMap model){
//        System.out.println("CREATE POST Success!");
//        // add element if necessary
//        if(elementRepo.findElementByName(newElementName) == null){
//            elementRepo.saveElement(newElementName);
//            List<Element> elementList = new ArrayList<>();
//            elementList.add(elementRepo.findElementByName(newElementName));
//            model.addAttribute("ElementsFromJava",elementList);
//            model.addAttribute("boolElementAdded",true);
//        }
//        else{
//            model.addAttribute("boolElementAdded",false);
//        }
//        // make new equation (if statement should ALWAYS be true! otherwise the equation already existed.
//        Equation newEquation = new Equation();
//        newEquation.setParent1(elementPair.element1);
//        newEquation.setParent2(elementPair.element2);
//        newEquation.setChild(elementRepo.findElementByName(newElementName));
//        if(equationRepo.findEquationByParentNames(elementPair.name1,elementPair.name2) == null){
//            equationRepo.saveEquation(newEquation);
//        }
//
//        model.addAttribute("databaseElements",elementRepo.findElementByName(newElementName));
//        return new ModelAndView("homepage",model);
//    }

    @RequestMapping(value="/createElement",method = RequestMethod.POST)
    public ModelAndView handleCreateElementPost(@ModelAttribute String newElementName, ModelMap model){
        // sout for debugging purposes
        System.out.println("CREATE POST Success!");

        // make the equation, but don't set the child
        Equation newEquation = new Equation();
        newEquation.setParent1(elementPair.element1);
        newEquation.setParent2(elementPair.element2);

        // make a new child element if necessary
        if(elementRepo.findElementByName(newElementName) == null){
            Element newElement = new Element(newElementName);
            elementRepo.saveElement(newElement);
            newElement.setOriginalEquation(newEquation);
            List<Element> elementList = new ArrayList<>();
            elementList.add(newElement);
            model.addAttribute("ElementsFromJava",elementList);
            model.addAttribute("boolElementAdded",true);
            newEquation.setNewElement(true);
        } else {
            model.addAttribute("boolElementAdded",false);
        }
        // fill the child of the equation
        newEquation.setChild(elementRepo.findElementByName(newElementName));

        model.addAttribute("databaseElements",elementRepo.findElementByName(newElementName));
        return new ModelAndView("homepage",model);
    }


}

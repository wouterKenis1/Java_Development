package vdab.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vdab.Model.Animal;
import vdab.Service.ManagerAnimal;


@Controller
@RequestMapping("/Animal")
public class AnimalController {
    @Autowired
    ManagerAnimal m_ManagerAnimal;

    @RequestMapping(value="/listAnimals", method= RequestMethod.GET)
    public ModelAndView listAnimals(ModelMap model){
        model.addAttribute("animals", m_ManagerAnimal.getAllAnimals());

        return new ModelAndView("listAnimals", model);
    }

    @RequestMapping(value="/addAnimal",method=RequestMethod.GET)
    public ModelAndView showAddView(ModelMap model){
        return new ModelAndView("addAnimal",model);
    }
    @RequestMapping(value="/addAnimal",method=RequestMethod.POST)
    public  ModelAndView addAnimal(@ModelAttribute Animal animal, ModelMap model){
        m_ManagerAnimal.addAnimal(animal);
        return new ModelAndView("redirect:/Animal/listAnimals");
    }

    @RequestMapping(value="/{name}/editAnimal",method=RequestMethod.GET)
    public ModelAndView showEditAnimal(@PathVariable("name") String name, ModelMap model){
        model.addAttribute("animalFromList", m_ManagerAnimal.getAnimalByName(name) );
        return new ModelAndView("editAnimal",model);
    }
    @RequestMapping(value="/{name}/editAnimal",method=RequestMethod.POST)
    public  ModelAndView editAnimal(@PathVariable("name") String name,@ModelAttribute Animal animal, ModelMap model){
        Animal firstAnimal = m_ManagerAnimal.getAnimalByName(name);
        //update firstAnimal
        firstAnimal.setName(animal.getName());
        firstAnimal.setSpecies(animal.getSpecies());
        firstAnimal.setFoodType(animal.getFoodType());
        firstAnimal.setLastEaten(animal.getLastEaten());

        return new ModelAndView("redirect:/Animal/listAnimals");
    }

    @RequestMapping(value="/{name}/deleteAnimal",method=RequestMethod.GET)
    public ModelAndView deleteAnimal(@PathVariable("name") String name, ModelMap model){
        m_ManagerAnimal.deleteAnimalByName(name);
        return new ModelAndView("redirect:/Animal/listAnimals");
    }


}




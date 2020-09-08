package vdab.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vdab.Controllers.AnimalController;
import vdab.DAO.AnimalDAO;
import vdab.Model.Animal;

import java.util.List;

@Service
public class ManagerAnimalImpl implements ManagerAnimal{

    @Autowired
    AnimalDAO animalDAO;

    @Override
    public List<Animal> getAllAnimals() {
        return animalDAO.getAllAnimals();
    }

    @Override
    public void addAnimal(Animal animal) {
        animalDAO.addAnimal(animal);
    }

    @Override
    public Animal getAnimalByName(String name) {
        return animalDAO.findByName(name);
    }

    @Override
    public void deleteAnimalByName(String name) {
        animalDAO.deleteAnimalByName(name);
    }
}

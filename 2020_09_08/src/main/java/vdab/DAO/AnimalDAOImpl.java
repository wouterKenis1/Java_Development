package vdab.DAO;

import org.springframework.stereotype.Repository;
import vdab.Model.Animal;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalDAOImpl implements AnimalDAO {

    private List<Animal> m_Animals = new ArrayList<>();

    AnimalDAOImpl(){
        Animal a = new Animal();
        a.setName("poes");
        a.setSpecies(Animal.Species.CAT);
        a.setFoodType(Animal.FoodType.Carnivore);
        a.setLastEaten("Steak");
        m_Animals.add(a);
    }

    @Override
    public List<Animal> getAllAnimals() {
        return m_Animals;
    }

    @Override
    public void addAnimal(Animal animal) {
        m_Animals.add(animal);
    }

    @Override
    public Animal findByName(String name) {
        for (Animal animal : m_Animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public void deleteAnimalByName(String name) {
        m_Animals.remove(findByName(name));
    }
}

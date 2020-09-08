package vdab.Service;

import vdab.Model.Animal;

import java.util.List;

public interface ManagerAnimal {
    List<Animal> getAllAnimals();
    void addAnimal(Animal animal);
    Animal getAnimalByName(String name);
    void deleteAnimalByName(String name);
}

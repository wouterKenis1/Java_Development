package vdab.DAO;

import vdab.Model.Animal;

import java.util.List;

public interface AnimalDAO {
    List<Animal> getAllAnimals();

    void addAnimal(Animal animal);
    Animal findByName(String name);
    void deleteAnimalByName(String name);
}

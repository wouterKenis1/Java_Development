package vdab.Model;

public class Animal {

    public enum Species{
        TIGER ("Tiger"),
        LION("Lion"),
        CAT( "Cat"),
        DOG( "Dog"),
        WOLF( "Wolf"),
        BIRD("Bird");
        Species(String name) {
        }
    }
    public enum FoodType{
        Herbivore("Herbivore"),
        Carnivore("Carnivore"),
        Omnivore("Omnivore");
        FoodType(String type){

        }
    }

    private String name;
    private Species species;
    private FoodType foodType;
    private String lastEaten;

    //Setters and Getters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Species getSpecies() {
        return species;
    }
    public void setSpecies(Species species) {
        this.species = species;
    }
    public FoodType getFoodType() {
        return foodType;
    }
    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }
    public String getLastEaten() {
        return lastEaten;
    }
    public void setLastEaten(String lastEaten) {
        this.lastEaten = lastEaten;
    }

    public String toString(){
        return name + " [Species=" + species.name() + ", FoodType=" + foodType.name() + ", LastFoodEaten=" + lastEaten + "]";
    }


}

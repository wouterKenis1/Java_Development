public class App {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Lion lion1 = new Lion();
        Tiger tiger1 = new Tiger();
        Monkey monkey1 = new Monkey();
        Lynx lynx1 = new Lynx();
        Wolf wolf1 = new Wolf();

        Lion lion2 = new Lion();
        Tiger tiger2 = new Tiger();
        Monkey monkey2 = new Monkey();
        Lynx lynx2 = new Lynx();
        Wolf wolf2 = new Wolf();

        zoo.addAnimal(lion1);
        zoo.addAnimal(tiger1);
        zoo.addAnimal(monkey1);
        zoo.addAnimal(lynx1);
        zoo.addAnimal(wolf1);

        zoo.addAnimal(lion2);
        zoo.addAnimal(tiger2);
        zoo.addAnimal(monkey2);
        zoo.addAnimal(lynx2);
        zoo.addAnimal(wolf2);

        zoo.printAnimals();
    }
}

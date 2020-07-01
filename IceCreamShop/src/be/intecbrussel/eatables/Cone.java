package be.intecbrussel.eatables;

public class Cone implements Eatable{
    private Flavor[] balls;

    public Cone() {
        this(new Flavor[0]); // not specified but implemented to avoid null
    }

    public Cone(Flavor[] flavors) {
        this.balls = flavors;
    }

    public void eat() {

        System.out.print("You are eating a be.intecbrussel.eatables.Cone with the following flavors:");
        for(Flavor ball : balls)
        {
            System.out.print(" " + ball);
        }
        System.out.println(); //to start the new line
    }
}

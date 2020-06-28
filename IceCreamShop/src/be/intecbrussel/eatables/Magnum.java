package be.intecbrussel.eatables;

public class Magnum implements Eatable{
    private MagnumType type;

    public Magnum(){
        this(MagnumType.MILKCHOCOLATE); //not specified but implemented to avoid null
    }
    public Magnum(MagnumType type) {
        this.type = type;
    }

    public void eat(){
        System.out.println("You are eating a be.intecbrussel.eatables.Magnum of the type: " + type);
    }
    public MagnumType getType(){return type;}
}

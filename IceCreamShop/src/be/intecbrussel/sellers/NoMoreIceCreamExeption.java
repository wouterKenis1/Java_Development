package be.intecbrussel.sellers;

public class NoMoreIceCreamExeption extends Exception {
    public NoMoreIceCreamExeption()
    {
        super("There was not enough Stock!");
    }

}

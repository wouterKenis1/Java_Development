package be.intecbrussel.sellers;
import be.intecbrussel.eatables.*;

public interface IceCreamSeller extends Profitable{
    Cone orderCone(Flavor[] flavors) throws NoMoreIceCreamExeption;
    IceRocket orderIceRocket() throws NoMoreIceCreamExeption;
    Magnum orderMagnum(MagnumType type) throws NoMoreIceCreamExeption;
}

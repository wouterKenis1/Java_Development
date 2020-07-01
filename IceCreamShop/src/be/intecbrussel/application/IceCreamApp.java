package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.NoMoreIceCreamExeption;
import be.intecbrussel.sellers.PriceList;

public class IceCreamApp {
    public static void main(String[] args) {
        PriceList prices = new PriceList(2.0,0.6,1.75);
        IceCreamSeller salonSeller = new IceCreamSalon(prices);

        try {
            Cone cone = salonSeller.orderCone(new Flavor[]{Flavor.BANANA, Flavor.CHOCOLATE, Flavor.LEMON});
            IceRocket rocket = salonSeller.orderIceRocket();
            Magnum magnum = salonSeller.orderMagnum(MagnumType.MILKCHOCOLATE);
        cone.eat();
        rocket.eat();
        magnum.eat();
        }
        catch (NoMoreIceCreamExeption e) {}

        System.out.println("Total profit: " + salonSeller.getProfit());

    }
}

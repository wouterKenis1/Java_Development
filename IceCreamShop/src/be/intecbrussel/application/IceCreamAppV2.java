package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.*;

public class IceCreamAppV2 {
    public static void main(String[] args) {
        PriceList prices = new PriceList(2.0, 0.6, 1.75);
        IceCreamSeller salonSeller = new IceCreamCar(prices, new Stock(0, 2, 5, 2));

        try {
            Cone cone = salonSeller.orderCone(new Flavor[]{Flavor.BANANA, Flavor.CHOCOLATE, Flavor.LEMON});
            cone.eat();
        } catch (NoMoreIceCreamExeption e) {
            System.out.println(e);
        }
        try {
            IceRocket rocket = salonSeller.orderIceRocket();
            rocket.eat();
        } catch (NoMoreIceCreamExeption e) {
            System.out.println(e);
        }
        try {
            Magnum magnum = salonSeller.orderMagnum(MagnumType.MILKCHOCOLATE);
            magnum.eat();
        } catch (NoMoreIceCreamExeption e) {
            System.out.println(e);
        }

        System.out.println("Total profit: " + salonSeller.getProfit());

        /**comments
         * there are 3 different try/catch statements as to allow all 3 order statements to complete
         * no profit will be granted when there is an exception. (won't pay for what isn't in stock)
         * the eat() statements are within the try/catch so that they are only accessed when the eatable is (was) in stock (not called for null objects)
        */

    }
}

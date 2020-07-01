package be.intecbrussel.sellers;

import be.intecbrussel.eatables.MagnumType;

public class PriceList {


    private double ballPrice;
    private double rocketPrice;
    private double magnumStandardPrice;

    public PriceList(){
        this(0.0,0.0,0.0);
    };
    public PriceList(double ballPrice, double rocketPrice, double magnumStandardPrice)
    {
        this.ballPrice = ballPrice;
        this.rocketPrice = rocketPrice;
        this.magnumStandardPrice = magnumStandardPrice;
    }

    public void setBallPrice(double ballPrice) {
        this.ballPrice = ballPrice;
    }

    public void setRocketPrice(double rocketPrice) {
        this.rocketPrice = rocketPrice;
    }

    public void setMagnumStandardPrice(double magnumStandardPrice) {
        this.magnumStandardPrice = magnumStandardPrice;
    }

    public double getBallPrice() {
        return ballPrice;
    }

    public double getRocketPrice() {
        return rocketPrice;
    }

    public double getMagnumPrice(MagnumType type) {

        double price = 0;
        switch(type)
        {
            case ALPINENUTS:
                price = magnumStandardPrice * 1.5;
                break;
            default:
                price = magnumStandardPrice;
        }
        return price;
    }


}

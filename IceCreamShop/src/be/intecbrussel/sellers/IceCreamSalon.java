package be.intecbrussel.sellers;
import be.intecbrussel.eatables.*;

public class IceCreamSalon implements IceCreamSeller{
    private PriceList priceList;
    private double totalProfit;

    public PriceList getPriceList() { return priceList; }
    public void setPriceList(PriceList priceList) { this.priceList = priceList; }
    public double getProfit(){ return totalProfit;}

    public IceCreamSalon(){}
    public IceCreamSalon(PriceList prices)
    {
        priceList = prices;
    }

    public Cone orderCone(Flavor[] flavours)
    {
        Cone cone = new Cone(flavours);
        totalProfit += flavours.length * priceList.getBallPrice();
        return cone;
    }
    public IceRocket orderIceRocket()
    {
        IceRocket rocket = new IceRocket();
        totalProfit += priceList.getRocketPrice();
        return rocket;
    }
    public Magnum orderMagnum(MagnumType type){
        Magnum magnum = new Magnum(type);
        totalProfit += priceList.getMagnumPrice(type);
        return new Magnum(type);
    }
    public String toString(){return "[IceCreamSalon]ToString() Called";}
}

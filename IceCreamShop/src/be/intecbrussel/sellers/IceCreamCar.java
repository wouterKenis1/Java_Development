package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamCar implements IceCreamSeller{
    private PriceList pricelist;
    private Stock stock;
    private double profit;
    ////////
    // CONSTRUCTORS
    ////////
    public IceCreamCar()
    {
        this(new PriceList(), new Stock());
    }
    public IceCreamCar(Stock stock)
    {
        this(new PriceList(), stock);
    }
    public IceCreamCar(PriceList prices)
    {
        this(prices, new Stock());
    }
    public IceCreamCar(PriceList prices, Stock stock)
    {
        this.stock = stock;
        pricelist = prices;
    }
    ////////
    // GETTERS AND SETTERS
    ////////
    public PriceList getPricelist() {
        return pricelist;
    }

    public void setPricelist(PriceList pricelist) {
        this.pricelist = pricelist;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
    ////////
    // FUNCTIONS
    ////////
    public Cone orderCone(Flavor[] flavors) throws NoMoreIceCreamExeption {
        if ((stock.getCones() < 1) || (stock.getBalls() < flavors.length)) {
            throw new NoMoreIceCreamExeption();
        }
        profit += pricelist.getBallPrice() * flavors.length;
        return prepareCone(flavors);
    }

    private Cone prepareCone(Flavor[] flavors) {
        Cone outCone = new Cone(flavors);
        stock.setCones(stock.getCones() - 1);
        stock.setBalls(stock.getBalls() - flavors.length);
        return outCone;
    }

    public IceRocket orderIceRocket() throws NoMoreIceCreamExeption{
        if(stock.getIceRockets() < 1)
        {
            throw new NoMoreIceCreamExeption();
        }
        profit += pricelist.getRocketPrice();
        return prepareIceRocket();
    }

    private IceRocket prepareIceRocket(){
        stock.setIceRockets(stock.getIceRockets() - 1);
        return new IceRocket();
    }

    public Magnum orderMagnum(MagnumType type) throws NoMoreIceCreamExeption{
        if(stock.getMagni() < 1)
        {
            throw new NoMoreIceCreamExeption();
        }
        profit += pricelist.getMagnumPrice(type);
        return prepareMagnum(type);
    }

    private Magnum prepareMagnum(MagnumType type){
        stock.setMagni(stock.getMagni() - 1);
        return new Magnum(type);
    }

    public double getProfit(){return profit;}




}

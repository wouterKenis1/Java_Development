package be.vdab.MoneyInDaBank;

public class Rekening {
    protected double geldbalans;
    public double GetBalance(){
        return geldbalans;
    }

    public void recieveMoney(double amount){
        geldbalans += amount;
    }
}

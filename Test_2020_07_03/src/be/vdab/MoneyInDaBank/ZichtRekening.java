package be.vdab.MoneyInDaBank;

import java.util.Set;

public class ZichtRekening extends  Rekening{
    public void doPayment(Rekening other, double amount){
        geldbalans -= amount;
        other.recieveMoney(amount);
    }
    public void doGeldophaling(double amount){
        geldbalans -= amount;
    }
}

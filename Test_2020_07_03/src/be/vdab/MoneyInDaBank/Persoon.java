package be.vdab.MoneyInDaBank;

import java.util.Set;

public class Persoon {
    private double cash = 0;

    private Rekening[] rekeningen;

    public Rekening[] getRekeningen() {
        return rekeningen;
    }

    public void setRekeningen(Rekening[] rekeningen) {
        this.rekeningen = rekeningen;
    }

    public  void addRekening(Rekening rekening){
        Rekening[] newRekeningen = new Rekening[rekeningen.length + 1];
        for(int i = 0; i < rekeningen.length; i++){
            newRekeningen[i] = rekeningen[i];
        }
        newRekeningen[newRekeningen.length - 1] = rekening;
        rekeningen = newRekeningen;
    }

    public void chargeRekening(Rekening rekening, double amount){
        cash -= amount;
        rekening.recieveMoney(amount);
    }

    public void getMoneyFromRekening(Rekening rekening, double amount){
        if(rekening instanceof ZichtRekening){
            ((ZichtRekening) rekening).doGeldophaling(amount);
            cash += amount;
        }
    }


    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}

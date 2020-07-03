package be.vdab.MoneyInDaBank;

import java.util.Arrays;


public class SpaarRekening extends Rekening{
    private ZichtRekening[] gekoppeldeRekeningen;

    public SpaarRekening(ZichtRekening zichtRekening){
        gekoppeldeRekeningen = new ZichtRekening[1];
        gekoppeldeRekeningen[0] = zichtRekening;
    }

    public SpaarRekening(ZichtRekening[] zichtRekeningen) {
        gekoppeldeRekeningen = zichtRekeningen;
    }

    public void doPayment(Rekening other, double amount){
        if(Arrays.asList(gekoppeldeRekeningen).contains(other)) {
            geldbalans -= amount;
            other.recieveMoney(amount);
        }
    }

    public void doInterest(double interestRate) {
        geldbalans += geldbalans*interestRate;
    }
}

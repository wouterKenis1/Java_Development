package be.vdab.MoneyInDaBank;

public class BankApp {
    static private Rekening[] rekeningen;
    static private Persoon[] klanten;

    public static void main(String[] args) {
        rekeningen = new Rekening[100];
        klanten = new Persoon[100];
        Persoon jan = new Persoon();
        jan.setCash(200);
        Persoon bert = new Persoon();
        bert.setCash(100);

        klanten[0] = jan;
        klanten[1] = bert;

        Rekening janZicht1 = new ZichtRekening();
        Rekening janZicht2 = new ZichtRekening();
        Rekening janZicht3 = new ZichtRekening();
        Rekening janSpaar1 = new SpaarRekening((ZichtRekening)janZicht1);

        rekeningen[0] = janZicht1;
        rekeningen[1] = janZicht2;
        rekeningen[2] = janZicht3;
        rekeningen[3] = janSpaar1;



    }
}

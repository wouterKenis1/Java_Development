package be.vdab;

public class file_20200617 {

    public static void main(String[] args)
    {
int base = 3;
int max = 50;
//printMultiples(base,max);
        //printAlphabet();
        commonMultiples(6,28,10000);
    }
    public static void printMultiples(int base, int max)
    {
int current = 0;
    while(current <= max)
    {
        System.out.println(current);
        current += base;
    }
}
    public static void printAlphabet()
    {
        char letter = 'a';
        while(letter <= 'z')
{
    System.out.println(letter);
            letter++;
        }
    }

    public static void askNumber()
    {
        //Scanner inputDevice = new Scanner(System.in);
int number = 0;
        do {

        } while(false);
    }

    public static void commonMultiples(int a, int b, int max) {
        for (int i = 0; i < max; i++) {
            if (((i % a) == 0) && ((i % b) == 0)) {
                System.out.println(i);
            }
        }
    }
}

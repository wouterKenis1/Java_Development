package be.vdab;

import java.util.Random;

public class RandomObject {
    private static Random randGenerator;
    private static int[] numbers;
    public static void main(String[] args) {
        randGenerator = new Random();
        numbers = new int[25];

        for(int i = 0; i < 25; i++) {
            numbers[i] = randGenerator.nextInt(1000);
        }
        for(int i : numbers)
        {
            printNumber(i);
        }
    }

    private static void printNumber(int x) {
        System.out.println(x);
        if(x < 250) {
            System.out.println("PIEF");
        }
        else if(x < 500) {
            System.out.println("POEF");
        }
        else{
            System.out.println("PAF");
        }
    }
}

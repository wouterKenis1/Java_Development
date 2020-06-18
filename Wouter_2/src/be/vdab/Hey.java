package be.vdab;

import java.util.Scanner;

//WOUTER
public class Hey {
    public static void main(String[] args) {
        Scanner inputDevice = new Scanner(System.in);
        System.out.println("Start nummer: ");
        int startNumber = inputDevice.nextInt();
        System.out.println("eind nummer: ");
        int endNumber = inputDevice.nextInt();
        System.out.println("increment: ");
        int increment = inputDevice.nextInt();
//        for (int i = 0; i <= 20; i++) {
//            System.out.println(number - i);
//        }
printNumbers(startNumber,endNumber,increment);
    }

    public static void printNumbers(int startingNumber, int endingNumber, int increment) {
        if (startingNumber > endingNumber) {
            increment = -increment;
            while (startingNumber >= endingNumber) {
                System.out.println(startingNumber);
                startingNumber += increment;
            }
        }
        else {
            while (startingNumber <= endingNumber) {
                System.out.println(startingNumber);
                startingNumber += increment;
            }

        }

    }


}

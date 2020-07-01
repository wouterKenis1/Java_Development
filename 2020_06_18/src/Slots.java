
import java.util.Scanner;
import java.util.Arrays;

public class Slots {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("--Galton Box--");

        System.out.print("Geef een aantal slots in: ");
        int size = input.nextInt();
        int[] outcome = new int[size];

        for(int currentSlot : outcome)
        {
            currentSlot = 0;
        }

        System.out.print("Geef een aantal ballen in: ");
        int ballAmount = input.nextInt();

        for (int i = 0; i < ballAmount; i++)
        {
            int slot = 0;
            for(int j = 0; j < size - 1;j++) {
                slot += ((Math.random() * 10) % 2);
            }
            outcome[slot]++;
        }

        System.out.println(Arrays.toString(outcome));
    }
}

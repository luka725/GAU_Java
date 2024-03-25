import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        final Random random = new Random();
        // Task N1
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(100);
        }
        System.out.println("Normal Array:");
        for(int i : array){
            System.out.println(i);
        }
        // Call bubble sort descending method
        bubbleSortDescending(array);
        System.out.println("Reverse sorted Array:");
        for(int i : array){
            System.out.println(i);
        }

        // Task N2
        Scanner scanner = new Scanner(System.in);
        int count_numbers_before_null = 0;
        int input;
        System.out.println("Enter non-negative integers (enter 0 to stop):");
        do {
            System.out.print("Enter a number: ");
            input = scanner.nextInt();

            if (input < 0) {
                System.out.println("Please enter a non-negative integer.");
            } else if (input != 0) {
                count_numbers_before_null++;
            }
        } while (input != 0);

        System.out.println("Loop stopped. Overly you entered " + count_numbers_before_null + " numbers");
        scanner.close();
    }
    public static void bubbleSortDescending(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
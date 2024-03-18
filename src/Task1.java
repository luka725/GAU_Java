import java.util.Random;

public class Task1 {
    private final Random random = new Random();
    private final double EvenIndexedAvg;
    private final double OddIndexedAvg;
    public Task1(int arraySize){
        int[] numbers = fillArray(arraySize);
        EvenIndexedAvg = evenAvg(numbers);
        OddIndexedAvg = oddAvg(numbers);
        printArrayMembers(numbers);
        getComparisonResult();
    }
    private int[] fillArray(int size){
        int[] temp_array = new int[size];
        for (int i = 0; i < size; i++){
            temp_array[i] = random.nextInt(100);
        }
        return temp_array;
    }
    private double evenAvg(int[] numbers){
        int evensSum = 0;
        int evensCount = 0;
        for (int i = 0; i < numbers.length; i++){
            if(i % 2 == 0){
                evensSum += numbers[i];
                evensCount += 1;
            }
        }
        return (double) evensSum/evensCount;
    }
    private double oddAvg(int[] numbers){
        int oddsCount = 0;
        int oddsSum = 0;
        for (int i = 0; i < numbers.length; i++){
            if(i % 2 != 0){
                oddsSum += numbers[i];
                oddsCount += 1;
            }
        }
        return  (double) oddsSum/oddsCount;
    }
    private void printArrayMembers(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    public void getComparisonResult(){
        System.out.println("Even indexed numbers average is equals to: " + EvenIndexedAvg);
        System.out.println("Odd indexed numbers average is equals to: " + OddIndexedAvg);
    }
}

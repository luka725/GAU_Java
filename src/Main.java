public class Main {
    public static void main(String[] args) {
        // #1
        double[] numbers = {3.50, 4.22, 3.14, 5.22};
        getMin(numbers);
        // #2
        task2(10);
        // #3
    }
    public static void getMin(double[] numbers){
        int size = numbers.length;
        int counter = 0;
        double min = numbers[0];

        do {
            if (numbers[counter] < min) {
                min = numbers[counter];
            }
            counter++;
        } while (counter < size - 1);

        System.out.println("minimum number in array is: " + min);
    }
    public static void task2(double x){
        System.out.println( (x == 0) ?  "X is zero!" : "Y is equals to: " + Math.sin(x) / x);
    }
}
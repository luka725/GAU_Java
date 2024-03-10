public class Main {
    public static void main(String[] args) {
        System.out.println("Triangle area with Heron formula, Task #1 ------->");
        HeronFormula(2, 3, 4);
        System.out.println("Square perimeter and area, Task #2 ------->");
        SquarePerimeterAndArea(2.5);
        System.out.println("Task #3 ------->");
        Task3(2.5, 1.5, 1);
        System.out.println("Task #4 ------->");
        Task4(10, 1.5);
        System.out.println("Sum of numbers, Task #5 -------<");
        SumOfNumbers(123);
        System.out.println("Print last digit, Task #6 ------->");
        PrintLastDigit(1231234);
        System.out.println("Print reversed number, Task #7 ------->");
        ReverseNumber(123);
        System.out.println("Trapezium area calculator, Task #8 ------->");
        TrapeziumArea(3, 6, 7);
        System.out.println("Triangle area calculator, Task #9 ------->");
        TriangleArea(3, 6);
    }

    public static void HeronFormula(double a, double b, double c){
        double s;
        double area;
        if(isValidTriangle(a, b, c))
        {
            s = (a + b + c) / 2;
            area = Math.sqrt(s * (s-a) * (s - b) * (s - c));
            System.out.println("area: " + area);
        }
        else
        {
            System.out.println("Triangle is not valid!");
        }
    }
    public static boolean isValidTriangle(double a, double b, double c){
        return a + b > c && a + c > b && b + c > a;
    }
    public static void SquarePerimeterAndArea(double a){
        double p = a * 4;
        double s = Math.pow(a, 2);
        System.out.println("Perimeter: " + p);
        System.out.println("Area: " + s);
    }
    public static void Task3(double A, double B, double x){
        double y = Math.sqrt(Math.log(A + B) + x) / Math.exp(x) + 1;
        double z = Math.abs(Math.pow(x, 2) - Math.pow(y, 2));
        System.out.println("Equation result: " + z);
    }
    public static void Task4(double A, double x){
        double y = Math.sqrt((Math.exp(x) + 1) / (Math.exp(x) + 2) + Math.sin(x));
        double z = A * y * Math.sin(y);
        System.out.println("Equation result: " + z);
    }
    public static void SumOfNumbers(int a){
        String n = Integer.toString(a);
        int count = 0;
        for (int i = 0; i < n.length(); i++){
            count +=  Character.getNumericValue(n.charAt(i));
        }
        System.out.println("Sum of " + a + " numbers is: " + count);
    }
    public static void PrintLastDigit(int a){
       String n = Integer.toString(a);
       for (int i = 0; i < n.length(); i++){
           if(n.length() - i == 1){
               System.out.println("Last digit of " + a + " is: " +n.charAt(i));
           }
       }
    }
    public static void ReverseNumber(int a){
        String n = Integer.toString(a);
        String rn = "";
        int i = n.length();
        while(i > 0){
            i--;
            rn += n.charAt(i);
        }
        System.out.println("Reversed number of " + n + " is: " + rn);
    }
    public static void TrapeziumArea(float a, float b, float h){
        System.out.println("Area equals to: " + ((a + b) * h) / 2);
    }
    public static void TriangleArea(float a, float h){
        System.out.println("Area of triangle equals to: " + (a * h) / 2);
    }
}

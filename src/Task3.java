public class Task3 {
    private final float a, b, c;
    public Task3(float a, float b, float c){
        this.a = a;
        this.b = b;
        this.c = c;
        if(validateTriangle()){
            calculateWithHeron();
        }
        else {
            System.out.println("Your triangle have issue :)");
        }
    }
    private boolean validateTriangle(){
        return (a + b > c) && (b + c > a) && (c + a > b);
    }
    private void calculateWithHeron(){
        double s = (a + b + c ) / 2;
        double Area = Math.sqrt(s * ((s - a) * (s - b) * (s - c)));
        System.out.println("Your triangle with sides " + a + ", " + b + ", " + c + " area is equals to: " + Area);
    }
}

public class Main {
    public static void main(String[] args) {
        // #1
        int count = 0;
        for (int i = 0; i < 15; i++) count += i + (i - 1);
        System.out.println("addition: " + count);
        count = 0;
        for (int i = 0; i < 15; i++) count += i * (i - 1);
        System.out.println("nultiplication: " + count);
        System.out.println("average: " + (count / 15));


        // #2
        double y;
        double x = -2;
        while (x <= 5.8){
            y = (3 * Math.pow(x, 4)) - (5 * Math.pow(x, 3)) - Math.pow(x ,2) - (6 * x) - 3;
            x += 0.02;
            if (y > 0){
                System.out.println(y);
            }
        }


        // #3
        float s = 1;
        for(float i = 1; i <= 100; i++){
            s += (1/i);
        }


        // #4
        double x1 = -10;
        double y1;
        while(x1 <= 25){
            x1 += 0.1;
            y1 = Math.cos(x1) / x1;
            System.out.println(y1);
        }

        // #5
        String num;
        int numcount;
        for (int i = 100; i <= 999; i++){
            num = Integer.toString(i);
            numcount = 0;
            for (int j = 0; j < num.length(); j++){
                numcount += Character.getNumericValue(num.charAt(j));
            }

            if( i % numcount == 0){
                System.out.println(i);
            }
        }

        // #6
        String stars = "";
        int starseachline = 10;
        while (starseachline > 0){
            for(int i = 0; i < starseachline; i++){
                stars += "* ";
            }
            System.out.println(stars);
            stars = "";
            starseachline--;
        }

    }
}
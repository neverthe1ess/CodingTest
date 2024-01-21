import java.util.Scanner;

public class BaekJoon_1193 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int dividend = 1;
        int divisor = 1;
        int value = 1;
        int n = 1;

        while(value < X){
            n++;
            value = n * (n + 1) / 2;
         }
        if(n % 2 == 0){
            dividend = n + X - value;
            divisor = 1 + value - X;
        } else {
            dividend = 1 + value - X;
            divisor = n + X - value;
        }
        System.out.println(dividend + "/" + divisor);
    }
}

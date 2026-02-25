import java.math.BigInteger;
import java.util.Scanner;

public class BaekJoon_1914 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BigInteger two = new BigInteger("2");
        BigInteger result = two.pow(N).subtract(BigInteger.ONE);
        System.out.println(result);
        if(N <= 20){
            hanoi(N, 1, 3);
        }
    }
    private static void hanoi(int n, int from, int to){
        if(n == 1){
            System.out.println(from + " " + to);
            return;
        }
        hanoi(n - 1, from, 6 - from - to);
        System.out.println(from + " " + to);
        hanoi(n - 1, 6 - from - to, to);
    }
}
